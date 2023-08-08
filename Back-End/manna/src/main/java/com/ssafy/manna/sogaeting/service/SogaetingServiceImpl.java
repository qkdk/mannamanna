package com.ssafy.manna.sogaeting.service;

import com.ssafy.manna.global.common.domain.Session;
import com.ssafy.manna.global.common.service.SessionService;
import com.ssafy.manna.member.Enums.BanCode;
import com.ssafy.manna.member.domain.Ban;
import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.sogaeting.dto.request.SogaetingLikeRequest;
import com.ssafy.manna.sogaeting.dto.request.SogaetingReportRequest;
import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponse;
import com.ssafy.manna.sogaeting.repository.CustomSogaetingRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SogaetingServiceImpl implements SogaetingService {

    private final MemberRepository memberRepository;
    private final CustomSogaetingRepository customSogaetingRepository;
    private final SessionService sessionService;

    @Override
    public void report(SogaetingReportRequest sogaetingReportRequest) throws Exception {

        Member member = memberRepository.findById(sogaetingReportRequest.getMemberId())
            .orElseThrow(() -> new Exception("일치하는 회원이 없습니다."));

        Ban ban = Ban.builder()
            .member(member)
            .opponent(member)
            .context(sogaetingReportRequest.getContext())
            .code(BanCode.valueOf(sogaetingReportRequest.getCode()))
            .build();
    }

    @Override
    public void Like(SogaetingLikeRequest sogaetingLikeRequest) throws Exception {
        Member sendMember = memberRepository.findById(sogaetingLikeRequest.getSenderId())
            .orElseThrow(() -> new Exception("일치하는 회원이 없습니다."));
        Member receiverMember = memberRepository.findById(sogaetingLikeRequest.getReceiverId())
            .orElseThrow(() -> new Exception("일치하는 회원이 없습니다."));
    }

    @Override
    public List<SogaetingMemberResponse> findMemberByCondition(String gender, Boolean isSmoker,
        Boolean isDrinker, String mbti, String userId) {

        List<SogaetingMemberResponse> findMembers = customSogaetingRepository.findMemberByCondition(
            gender, isSmoker, isDrinker, mbti, sessionService.getOffset(userId));
        updateOnlineState(findMembers);

        return findMembers;
    }

    @Override
    public List<SogaetingMemberResponse> findMemberByConditionAndOnlineState(String gender,
        Boolean isSmoker, Boolean isDrinker, String mbti, String userId) {

        // 온라인인 사람부터 찾기
        List<Session> onlineMembers = sessionService.findOnlineMembers();
        List<String> onlineMembersId = onlineMembers.stream().map(Session::getUserId).toList();
        List<SogaetingMemberResponse> memberByConditionAndOnlineState =
            customSogaetingRepository.findMemberByConditionAndOnlineState(
                onlineMembersId, gender, isSmoker, isDrinker, mbti,
                sessionService.getOffset(userId));

        memberByConditionAndOnlineState
            .forEach(member -> member.updateOnlineState(true));

        return memberByConditionAndOnlineState;
    }

    private void updateOnlineState(List<SogaetingMemberResponse> findMembers) {
        for (SogaetingMemberResponse findMember : findMembers) {
            findMember.updateOnlineState(sessionService.checkMemberIsOnline(findMember.getId()));
        }
    }
}
