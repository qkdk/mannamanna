package com.ssafy.manna.sogaeting.service;

import com.ssafy.manna.member.Enums.BanCode;
import com.ssafy.manna.member.domain.Ban;
import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.sogaeting.dto.request.SogaetingReportRequest;
import jakarta.transaction.Transactional;
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
}
