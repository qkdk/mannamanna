package com.ssafy.manna.mission.Enums;

public enum MissionResponseMessage {

    MISSION_ASSIGN_SUCCESS("mission assign success"),
    MISSION_ASSIGN_ERROR("mission assign error"),
    MISSION_CALL_SUCCESS("mission call success"),
    MISSION_GIVEUP_SUCCESS("mission giveup success"),
    MISSION_GIVEUP_ERROR("mission giveup error"),
    MISSION_DO_SUCCESS("mission do success"),
    MISSION_DO_ERROR("mission do error"),
    MISSION_FINISH_SUCCESS("mission finish success")
    ;

    private final String message;


    MissionResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
