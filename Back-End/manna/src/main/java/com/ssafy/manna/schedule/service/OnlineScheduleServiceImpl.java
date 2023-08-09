package com.ssafy.manna.schedule.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.schedule.domain.OnlineSchedule;
import com.ssafy.manna.schedule.domain.Schedule;
import com.ssafy.manna.schedule.dto.request.OnlineScheduleRequest;
import com.ssafy.manna.schedule.dto.response.OnlineScheduleResponse;
import com.ssafy.manna.schedule.repository.OnlineScheduleRepository;
import com.ssafy.manna.schedule.repository.ScheduleRepository;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private final ScheduleRepository scheduleRepository;

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

    @Override
    public List<OnlineScheduleResponse> getAllSchedule(String userId) {
        List<OnlineSchedule> allSchedule = scheduleRepository.findAllByMemberId(userId);
        List<OnlineScheduleResponse> scheduleResponseList = new ArrayList<>();
        for(Schedule schedule:allSchedule){
            //날짜
            LocalDateTime localTime = schedule.getDate();
            int year = localTime.getYear();             // 년도 추출
            int month = localTime.getMonthValue();      // 월 추출
            int day = localTime.getDayOfMonth();        // 일 추출
            String extractedDate = String.format("%04d년 %02d월 %02d일", year, month, day);

            OnlineScheduleResponse onlineSchedule = OnlineScheduleResponse.builder()
                    .opponentId(schedule.getOpponent().getId())
                    .date(extractedDate)
                    .build();
            scheduleResponseList.add(onlineSchedule);
        }
        return scheduleResponseList;
    }
}
