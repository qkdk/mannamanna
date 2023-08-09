package com.ssafy.manna.schedule.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.schedule.domain.OnlineSchedule;
import com.ssafy.manna.schedule.dto.request.OnlineScheduleRequest;
import com.ssafy.manna.schedule.repository.OnlineScheduleRepository;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OnlineScheduleServiceImpl implements OnlineScheduleService{

    private final OnlineScheduleRepository onlineScheduleRepository;

    @Override
    public void insertSchedule(OnlineScheduleRequest scheduleRequest) {
        Member member = scheduleRequest.getMember();
        Member opponent = scheduleRequest.getOpponent();
        LocalDateTime date = scheduleRequest.getDate();
        // KST 시간대로 변환
        ZoneId kstZone = ZoneId.of("Asia/Seoul");
        ZonedDateTime kstDateTime = date.atZone(kstZone);

        String url = scheduleRequest.getUrl();

        OnlineSchedule onlineSchedule = OnlineSchedule.builder()
                .member(member)
                .opponent(opponent)
                .date(kstDateTime.toLocalDateTime())
                .url(url)
                .build();

        onlineScheduleRepository.save(onlineSchedule);
    }

    @Override
    public void deleteSchedule() {

    }
}
