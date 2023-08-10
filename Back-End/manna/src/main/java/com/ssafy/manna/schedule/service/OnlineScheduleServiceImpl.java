package com.ssafy.manna.schedule.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.OneLineFormatter;
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
    private final MemberRepository memberRepository;
//    private final NoteService noteService;

    @Override
    public void insertSchedule(OnlineScheduleRequest scheduleRequest) {
        Member female = scheduleRequest.getFemale();
        Member male = scheduleRequest.getMale();
        LocalDateTime date = scheduleRequest.getDate();
        // KST 시간대로 변환
        ZoneId kstZone = ZoneId.of("Asia/Seoul");
        ZonedDateTime kstDateTime = date.atZone(kstZone);

        String url = scheduleRequest.getUrl();

        OnlineSchedule onlineSchedule = OnlineSchedule.builder()
                .female(female)
                .male(male)
                .date(kstDateTime.toLocalDateTime())
                .url(url)
                .build();

        onlineScheduleRepository.save(onlineSchedule);
    }

    @Override
    public void deleteSchedule() {

    }

    //스케줄 삭제
    @Override
    public void deleteSchedule(Integer id) throws Exception {
////        Schedule schedule = scheduleRepository.findById(id).orElseThrow(()->new Exception("스케줄 정보가 없습니다."));
//        OnlineSchedule schedule = onlineScheduleRepository.findById(id).orElseThrow(() -> new Exception("스케줄 정보가 없습니다."));
//
////        System.out.println("삭제할 스케줄:"+schedule);
//        //현재시간₩
//        ZoneId koreaZone = ZoneId.of("Asia/Seoul");
//        ZonedDateTime koreaTime = ZonedDateTime.now(koreaZone);
//        LocalDateTime localDateTime = koreaTime.toLocalDateTime();
//
//        //반대 쪽도 삭제
//        Member member = schedule.getMember();
//        Member opponent = schedule.getOpponent();
//        LocalDateTime date = schedule.getDate();
//
//        Schedule opponentSchedule = scheduleRepository.findByMemberIdAndOpponentIdAndDate(
//                opponent.getId(), member.getId(), date);
//
//        scheduleRepository.delete(schedule);
//        scheduleRepository.delete(opponentSchedule);

        //스케줄 삭제 시, 쪽지 보내기( 000님이 스케줄을 취소하셨습니다.)
//        String subject = member.getName()+"님이 스케줄을 취소하셨습니다.";
//        String content = subject+"\n 스케줄에서 삭제됩니다.";
//        NoteSendRequest noteSendRequest = NoteSendRequest.builder()
//                .receiver(opponent.getId())
//                .subject(subject)
//                .content(content)
//                .date(localDateTime)
//                .isSogae(false)
//                .sender("admin")
//                .build();
//        noteService.send(noteSendRequest);

    }

    @Override
    public List<OnlineScheduleResponse> getAllSchedule(String userId) throws Exception {
        //member 가 female인지 male인지 확인
        Member member = memberRepository.findById(userId).orElseThrow(()->new Exception("회원이 존재하지 않습니다."));
        List<OnlineSchedule> allSchedule;
        if(member.getGender().equals("female")){
            //여자이면
            allSchedule = onlineScheduleRepository.findByFemaleId(userId);
          }
        else{
            //남자이면
            allSchedule = onlineScheduleRepository.findByMaleId(userId);
        }

        List<OnlineScheduleResponse> scheduleResponseList = new ArrayList<>();
        for(OnlineSchedule schedule:allSchedule){
            //날짜
            LocalDateTime localTime = schedule.getDate();
            int year = localTime.getYear();             // 년도 추출
            int month = localTime.getMonthValue();      // 월 추출
            int day = localTime.getDayOfMonth();        // 일 추출
            String extractedDate = String.format("%04d년 %02d월 %02d일", year, month, day);

            Member opponent;
            if(member.getGender().equals("female")){
                opponent = schedule.getMale();
            }
            else{
                opponent = schedule.getFemale();
        }

            OnlineScheduleResponse onlineSchedule = OnlineScheduleResponse.builder()
                    .scheduleId(schedule.getId())
                    .opponentId(opponent.getId())
                    .date(extractedDate)
                    .build();
            scheduleResponseList.add(onlineSchedule);
        }
        return scheduleResponseList;
    }
}
