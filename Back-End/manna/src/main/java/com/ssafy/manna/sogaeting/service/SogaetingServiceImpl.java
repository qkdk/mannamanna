package com.ssafy.manna.sogaeting.service;

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

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SogaetingServiceImpl implements SogaetingService{
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
        Member sendMember = memberRepository.findById(sogaetingLikeRequest.getSenderId()).orElseThrow(() -> new Exception("일치하는 회원이 없습니다."));
        Member receiverMember = memberRepository.findById(sogaetingLikeRequest.getReceiverId()).orElseThrow(() -> new Exception("일치하는 회원이 없습니다."));
    }

    @Override
    public List<SogaetingMemberResponse> findMemberByCondition(String gender, Boolean isSmoker,
        Boolean isDrinker, String mbti) {
        List<SogaetingMemberResponse> findMembers = customSogaetingRepository.findMemberByCondition(
            gender, isSmoker, isDrinker, mbti);
        updateOnlineState(findMembers);

        return findMembers;
    }

    private void updateOnlineState(List<SogaetingMemberResponse> findMembers) {
        for (SogaetingMemberResponse findMember : findMembers) {
            findMember.updateOnlineState(sessionService.checkMemberIsOnline(findMember.getId()));
        }
    }
}
