package com.ssafy.manna.mission.service;

import com.ssafy.manna.global.common.domain.CodeDetail;
import com.ssafy.manna.mission.dto.request.MissionAssignRequest;

import java.util.List;

public interface MissionService {

    void assignMission(MissionAssignRequest missionAssignRequest) throws Exception;

}
