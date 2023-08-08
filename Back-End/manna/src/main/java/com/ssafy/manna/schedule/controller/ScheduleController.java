package com.ssafy.manna.schedule.controller;

import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.member.service.MemberService;
import com.ssafy.manna.schedule.dto.request.OnlineScheduleRequest;
import com.ssafy.manna.schedule.service.OnlineScheduleService;
import com.ssafy.manna.schedule.service.ScheduleService;
import java.awt.image.RescaleOp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
@EnableWebMvc
@Slf4j
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final OnlineScheduleService onlineScheduleService;

    //온라인 스케줄 insert
    @PostMapping("/insert")
    public ResponseEntity<?> inseretOnlineSchedule(@RequestBody OnlineScheduleRequest scheduleRequest){
        try {
            onlineScheduleService.insertSchedule(scheduleRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
