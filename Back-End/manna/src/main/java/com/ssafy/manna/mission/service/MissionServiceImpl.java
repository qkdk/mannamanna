package com.ssafy.manna.mission.service;

import com.ssafy.manna.global.common.domain.CodeDetail;
import com.ssafy.manna.global.common.repository.CodeDetailRepository;
import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.mission.Enums.MissionCode;
import com.ssafy.manna.mission.domain.Mission;
import com.ssafy.manna.mission.domain.MissionQuestion;
import com.ssafy.manna.mission.dto.request.MissionAssignRequest;
import com.ssafy.manna.mission.dto.response.MissionCallResponse;
import com.ssafy.manna.mission.repository.MissionQuestionRepository;
import com.ssafy.manna.mission.repository.MissionRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MissionServiceImpl implements MissionService {

    private final CodeDetailRepository codeDetailRepository;
    private final MissionRepository missionRepository;
    private final MissionQuestionRepository missionQuestionRepository;
    private final MemberRepository memberRepository;

    // 소개팅이 성공하면 미션 6가지 생성해주기
    @Override
    public void assignMission(MissionAssignRequest missionAssignRequest) throws Exception {
        // 코드가 M인 목록을 랜덤으로 6가지 불러옴
        List<CodeDetail> codeDetails = codeDetailRepository.findRandomTop6ById("M");
        Mission mission = missionRepository.findById(missionAssignRequest.getMissionId())
                .orElseThrow(() -> new RuntimeException("mission not found"));
        codeDetails.stream().forEach(codeDetail -> {
            MissionQuestion missionQuestion = MissionQuestion.builder()
                    .mission(mission)
                    .maleIsDone(false)
                    .femaleIsDone(false)
                    .code(MissionCode.valueOf("M1"))
                    .content(codeDetail.getName())
                    .build();
            missionQuestionRepository.save(missionQuestion);
        });
    }

    // 해당하는 회원의 미션정보 불러오기
    @Override
    public List<MissionCallResponse> getMissionListByUserId(String id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("일치하는 회원이 없습니다."));
        String gender = member.getGender();
        List<Mission> missions;
        if ("male".equals(gender)) {
            missions = missionRepository.findByMaleId(member.getId());
        } else if ("female".equals(gender)) {
            missions = missionRepository.findByFemaleId(member.getId());
        } else {
            throw new RuntimeException("유효하지 않은 성별입니다.");
        }

        List<MissionQuestion> missionQuestions = missionQuestionRepository.findByMissionIn(
                missions);

        List<MissionCallResponse.MissionQuestion> missionQuestionList = new ArrayList<>();
        for (MissionQuestion missionQuestion : missionQuestions) {
            missionQuestionList.add(new MissionCallResponse.MissionQuestion(
                    missionQuestion.getId(),
                    missionQuestion.getMaleIsDone(),
                    missionQuestion.getFemaleIsDone(),
                    missionQuestion.getContent()
            ));
        }

        List<MissionCallResponse> responseList = new ArrayList<>();

        for (Mission mission : missions) {
            MissionCallResponse missionCallResponse = new MissionCallResponse(
                    mission.getId(),
                    mission.getStartDate(),
                    mission.getEndDate(),
                    missionQuestionList
            );
            responseList.add(missionCallResponse);
        }
        return responseList;
    }
}
