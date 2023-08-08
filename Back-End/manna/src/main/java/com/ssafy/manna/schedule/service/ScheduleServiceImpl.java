package com.ssafy.manna.schedule.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.schedule.domain.OnlineSchedule;
import com.ssafy.manna.schedule.domain.Schedule;
import com.ssafy.manna.schedule.dto.request.ScheduleRequest;
import com.ssafy.manna.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ScheduleServiceImpl implements ScheduleService{

    private final MemberRepository memberRepository;

    private  final ScheduleRepository scheduleRepository;
    @Override
    public void addSchedule(ScheduleRequest scheduleRequest) throws Exception {
        Member member = memberRepository.findById(scheduleRequest.getMemberId()).orElseThrow(()-> new Exception("회원 정보가 없습니다."));
        Member opponent = memberRepository.findById(scheduleRequest.getOpponentId()).orElseThrow(()-> new Exception("회원 정보가 없습니다."));

        //스케줄 정보 먼저 저장
        Schedule schedule = Schedule.builder()
                .member(member)
                .opponent(opponent)
                .date(scheduleRequest.getDate())
                .build();

        scheduleRepository.save(schedule);


        OnlineSchedule onlineSchedule = OnlineSchedule.builder()
                .build();

    }
}
