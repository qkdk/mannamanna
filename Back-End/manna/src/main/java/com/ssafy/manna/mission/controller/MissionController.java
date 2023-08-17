package com.ssafy.manna.mission.controller;

import com.ssafy.manna.global.util.ResponseTemplate;
import com.ssafy.manna.mission.Enums.MissionResponseMessage;
import com.ssafy.manna.mission.dto.request.MissionAssignRequest;
import com.ssafy.manna.mission.dto.request.MissionDoRequest;
import com.ssafy.manna.mission.dto.request.MissionGiveUpRequest;
import com.ssafy.manna.mission.dto.request.MissionStartRequest;
import com.ssafy.manna.mission.dto.response.MissionCallResponse;
import com.ssafy.manna.mission.dto.response.MissionDetailResponse;
import com.ssafy.manna.mission.dto.response.MissionFinishResponse;
import com.ssafy.manna.mission.dto.response.MissionParticipantResponse;
import com.ssafy.manna.mission.repository.MissionRepository;
import com.ssafy.manna.mission.service.MissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@EnableWebMvc
@Slf4j
@RequestMapping("/api/mission")
public class MissionController {

    private final MissionRepository missionRepository;
    private final MissionService missionService;


    // 소개팅이 성공하면 미션 6가지 생성해주기
    @PostMapping(value = "/assign")
    public ResponseEntity<ResponseTemplate<MissionResponseMessage>> assignMission(@RequestBody MissionAssignRequest missionAssignRequest) throws Exception {

        missionService.assignMission(missionAssignRequest);

        return ResponseEntity.ok(
                ResponseTemplate.<MissionResponseMessage>builder()
                        .result(true)
                        .msg(MissionResponseMessage.MISSION_ASSIGN_SUCCESS.getMessage())
                        .build()
        );

    }

    // 해당하는 회원의 미션정보 불러오기
    @GetMapping(value = "/call/{id}")
    public ResponseEntity<ResponseTemplate<List<MissionCallResponse>>> getMissionListByUserId(
            @Validated @PathVariable("id") String id) {

        List<MissionCallResponse> response = missionService.getMissionListByUserId(id);

        return ResponseEntity.ok(
                ResponseTemplate.<List<MissionCallResponse>>builder()
                        .msg(MissionResponseMessage.MISSION_CALL_SUCCESS.getMessage())
                        .data(response)
                        .result(true)
                        .build()
        );

    }

    // 미션 포기하기
    @PutMapping(value = "/giveup")
    public ResponseEntity<ResponseTemplate<MissionGiveUpRequest>> giveUpMissionByMissionId(
            @RequestBody MissionAssignRequest missionGiveUpRequest) {

        missionService.giveUpMission(missionGiveUpRequest);

        ResponseTemplate<MissionGiveUpRequest> response = ResponseTemplate.<MissionGiveUpRequest>builder()
                .result(true)
                .msg(MissionResponseMessage.MISSION_GIVEUP_SUCCESS.getMessage())
                .build();

        return ResponseEntity.ok(response);

    }

    // 미션 사진 업로드
    @PutMapping(value = "/do", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseTemplate<MissionResponseMessage>> doMission(
            @RequestPart("missionDoRequest") MissionDoRequest missionDoRequest,
            @RequestPart("missionPicture") MultipartFile missionPicture) throws IOException {

        missionService.doMission(missionDoRequest, missionPicture);

        return ResponseEntity.ok(
                ResponseTemplate.<MissionResponseMessage>builder()
                        .result(true)
                        .msg(MissionResponseMessage.MISSION_DO_SUCCESS.getMessage())
                        .build()
        );

    }


    // 미션 완료 후 인증서 발급
    @GetMapping(value = "/finish/{missionId}")
    public ResponseEntity<ResponseTemplate<MissionFinishResponse>> finishMission(
            @Validated @PathVariable("missionId") Integer missionId) throws Exception {

        MissionFinishResponse missionFinishResponse = missionService.finishMission(missionId);

        return new ResponseEntity<>(
                ResponseTemplate.<MissionFinishResponse>builder()
                        .result(true)
                        .msg(MissionResponseMessage.MISSION_FINISH_SUCCESS.getMessage())
                        .data(missionFinishResponse)
                        .build(),
                HttpStatus.OK);
    }

    // 소개팅 성공 시 미션 시작
    @PostMapping(value = "/start")
    public ResponseEntity<ResponseTemplate<MissionResponseMessage>> startMission(@RequestBody MissionStartRequest missionStartRequest) {
        missionService.startMission(missionStartRequest);

        return ResponseEntity.ok(
                ResponseTemplate.<MissionResponseMessage>builder()
                        .result(true)
                        .msg(MissionResponseMessage.MISSION_START_SUCCESS.getMessage())
                        .build()
        );
    }

    //사람 id로 상대방 id(이름) 까지 가져오기
    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplate<MissionParticipantResponse>> getParticipant(@PathVariable("id") String userId) {
        MissionParticipantResponse missionParticipantResponse = missionService.getParticipant(userId);
        return new ResponseEntity<>(
                ResponseTemplate.<MissionParticipantResponse>builder()
                        .result(true)
                        .msg(MissionResponseMessage.MISSION_GET_PARTICIPANT_SUCCESS.getMessage())
                        .data(missionParticipantResponse)
                        .build(),
                HttpStatus.OK
        );
    }

    //미션 별 정보 get
    @GetMapping("/{missionId}/{cardId}/{userId}")
    public ResponseEntity<ResponseTemplate<MissionDetailResponse>> getImagePerCard(@PathVariable("missionId") Integer missionId, @PathVariable("cardId") Integer cardId
            , @PathVariable("userId") String userId) {
        return new ResponseEntity<>(
                ResponseTemplate.<MissionDetailResponse>builder()
                        .result(true)
                        .msg(MissionResponseMessage.MISSION_GET_DETAIL_SUCCESS.getMessage())
                        .data(missionService.getImagePerCard(missionId, cardId, userId))
                        .build(),
                HttpStatus.OK
        );
    }

}
