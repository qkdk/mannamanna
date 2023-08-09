package com.ssafy.manna.mission.service;

import com.ssafy.manna.global.common.domain.CodeDetail;
import com.ssafy.manna.mission.dto.request.MissionAssignRequest;

import java.util.List;

public interface MissionService {

    // 소개팅이 성공하면 미션 6가지 생성해주기
    void assignMission(MissionAssignRequest missionAssignRequest) throws Exception;

}
