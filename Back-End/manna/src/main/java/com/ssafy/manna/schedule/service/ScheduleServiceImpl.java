package com.ssafy.manna.schedule.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.schedule.domain.OnlineSchedule;
import com.ssafy.manna.schedule.domain.Schedule;
import com.ssafy.manna.schedule.dto.request.ScheduleRequest;
import com.ssafy.manna.schedule.dto.response.OnlineScheduleResponse;
import com.ssafy.manna.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ScheduleServiceImpl implements ScheduleService{

    private final MemberRepository memberRepository;

    private  final ScheduleRepository scheduleRepository;

    @Override
    public void deleteSchedule(Integer id) throws Exception {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(()->new Exception("스케줄 정보가 없습니다."));
        scheduleRepository.delete(schedule);
    }

    @Override
    public List<Schedule> getAllSchedule(String userId) throws Exception {
        //member 가 female인지 male인지 확인
        Member member = memberRepository.findById(userId).orElseThrow(()->new Exception("회원이 존재하지 않습니다."));
        List<Schedule> allSchedule;
        if(member.getGender().equals("female")){
            //여자이면
            allSchedule = scheduleRepository.findByFemaleId(userId);
        }
        else{
            //남자이면
            allSchedule = scheduleRepository.findByMaleId(userId);
        }

//        List<OnlineScheduleResponse> scheduleResponseList = new ArrayList<>();
//        for(OnlineSchedule schedule:allSchedule){
//            //날짜
//            LocalDateTime localTime = schedule.getDate();
//            int year = localTime.getYear();             // 년도 추출
//            int month = localTime.getMonthValue();      // 월 추출
//            int day = localTime.getDayOfMonth();        // 일 추출
//            String extractedDate = String.format("%04d년 %02d월 %02d일", year, month, day);
//
//            Member opponent;
//            if(member.getGender().equals("female")){
//                opponent = schedule.getMale();
//            }
//            else{
//                opponent = schedule.getFemale();
//            }
//            OnlineScheduleResponse onlineSchedule = OnlineScheduleResponse.builder()
//                    .scheduleId(schedule.getId())
//                    .opponentId(opponent.getId())
//                    .date(extractedDate)
//                    .build();
//            scheduleResponseList.add(onlineSchedule);
//        }
        return allSchedule;
    }
}
