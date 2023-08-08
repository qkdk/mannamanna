package com.ssafy.manna.mission.service;

import com.ssafy.manna.global.common.domain.CodeDetail;
import com.ssafy.manna.global.common.repository.CodeDetailRepository;
import com.ssafy.manna.mission.Enums.MissionCode;
import com.ssafy.manna.mission.domain.Mission;
import com.ssafy.manna.mission.domain.MissionQuestion;
import com.ssafy.manna.mission.dto.request.MissionAssignRequest;
import com.ssafy.manna.mission.repository.MissionQuestionRepository;
import com.ssafy.manna.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MissionServiceImpl implements MissionService{

    private final CodeDetailRepository codeDetailRepository;
    private final MissionRepository missionRepository;
    private final MissionQuestionRepository missionQuestionRepository;


    // 소개팅이 성공하면 미션 6가지 생성해주기
    @Override
    public void assignMission(MissionAssignRequest missionAssignRequest) throws Exception{

        List<CodeDetail> codeDetails = codeDetailRepository.findRandomTop6ById("M");
        System.out.println(codeDetails.toString());
        Mission mission = missionRepository.findById(missionAssignRequest.getMissionId()).orElseThrow(() -> new RuntimeException("mission not found"));
        System.out.println(mission);
        codeDetails.stream().forEach(codeDetail -> {
            MissionQuestion missionQuestion = MissionQuestion.builder()
                    .mission(mission)
                    .maleIsDone(false)
                    .femaleIsDone(false)
                    .code(MissionCode.valueOf("M"))
                    .content(codeDetail.getName())
                    .build();
            missionQuestionRepository.save(missionQuestion);
            System.out.println("dd");
        });
    }
}
