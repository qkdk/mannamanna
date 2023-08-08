package com.ssafy.manna.mission.controller;

import com.ssafy.manna.global.util.ResponseTemplate;
import com.ssafy.manna.mission.dto.request.MissionAssignRequest;
import com.ssafy.manna.mission.repository.MissionRepository;
import com.ssafy.manna.mission.service.MissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
@EnableWebMvc
@Slf4j
@RequestMapping("/api/mission")
public class MissionController {

    private final MissionRepository missionRepository;
    private final MissionService missionService;


    // 소개팅이 성공하면 미션 6가지 생성해주기
    @PostMapping(value = "assign")
    public ResponseEntity<?> assignMission(@RequestBody MissionAssignRequest missionAssignRequest){
        ResponseTemplate<?> body;
        try{
            missionService.assignMission(missionAssignRequest);
            return ResponseEntity.ok("mission assign success");
        } catch (Exception e){
            body = ResponseTemplate.builder()
                    .result(false)
                    .msg("미션 생성 에러")
                    .build();
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        }
    }
}
