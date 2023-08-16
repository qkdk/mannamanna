package com.ssafy.manna.mission.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionParticipantResponse {

    private String userId;
    private String userName;
    private String opponentId;
    private String opponentName;
    //missinon id도 넘겨주기
    private int missionId;

}
