package com.ssafy.manna.mission.service;

import com.ssafy.manna.mission.dto.request.MissionAssignRequest;
import com.ssafy.manna.mission.dto.response.MissionCallResponse;
import java.util.List;

public interface MissionService {

    // 소개팅이 성공하면 미션 6가지 생성해주기
    void assignMission(MissionAssignRequest missionAssignRequest) throws Exception;

    List<MissionCallResponse> getMissionListByUserId(String userid);
}
