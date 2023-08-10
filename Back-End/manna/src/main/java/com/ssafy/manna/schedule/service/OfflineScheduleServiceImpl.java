package com.ssafy.manna.schedule.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.schedule.domain.OfflineSchedule;
import com.ssafy.manna.schedule.domain.ReservePlace;
import com.ssafy.manna.schedule.dto.request.OfflineScheduleRequest;
import com.ssafy.manna.schedule.repository.OfflineScheduleRepository;
import com.ssafy.manna.schedule.repository.ReservePlaceRepository;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OfflineScheduleServiceImpl implements OfflineScheduleService{

    private final OfflineScheduleRepository offlineScheduleRepository;
    private final MemberRepository memberRepository;
    private final ReservePlaceRepository reserveAddressRepository;
    @Override
    public void insertSchedule(OfflineScheduleRequest scheduleRequest) throws Exception {
        Member female = memberRepository.findById(scheduleRequest.getFemaleId()).orElseThrow(()->new Exception("회원 정보가 없습니다."));
        Member male = memberRepository.findById(scheduleRequest.getMaleId()).orElseThrow(()->new Exception("회원 정보가 없습니다."));
        String dateStr = scheduleRequest.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
        LocalDateTime time = LocalDateTime.parse(dateStr, formatter);
        // KST 시간대로 변환
        ZoneId kstZone = ZoneId.of("Asia/Seoul");
        ZonedDateTime kstDateTime = time.atZone(kstZone);
        //예약 장소 주소 id로
        Integer reserveAddressId = scheduleRequest.getReserveAddressId();
//
        ReservePlace reservePlace = reserveAddressRepository.findById(reserveAddressId).orElseThrow(()->new Exception("예약 장소 정보가 없습니다."));
//
        OfflineSchedule offlineSchedule = OfflineSchedule.builder()
                .female(female)
                .male(male)
                .date(kstDateTime.toLocalDateTime())
                .reserve(reservePlace)
                .build();
//
        offlineScheduleRepository.save(offlineSchedule);
    }
}
