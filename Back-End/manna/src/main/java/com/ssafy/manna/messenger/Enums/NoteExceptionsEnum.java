package com.ssafy.manna.messenger.Enums;

public enum NoteExceptionsEnum {

    NOTE_SEND_ERROR("쪽지 전송에 실패했습니다."),
    NOTE_SEND_SUCCESS("쪽지 전송에 성공했습니다."),
    NOTE_SOGAE_SEND_ERROR("소개팅 쪽지 전송에 실패했습니다."),
    NOTE_DELETE_ERROR("쪽지 삭제에 실패했습니다."),
    SOGAE_DECLINE_MESSAGE("소개팅을 거절하셨습니다."),
    SOGAE_ACCEPT_MESSAGE("소개팅을 수락하셨습니다."),
    NOTE_RECEIVER_ERROR("받는 회원 정보가 없습니다."),
    NOTE_SENDER_ERROR("보내는 회원 정보가 없습니다."),
    NOTE_EXIST_ERROR("쪽지가 존재하지 않습니다.");


    private final String value;
    NoteExceptionsEnum(String value){
        this.value=value;
    }

    public String getValue(){return value;}
}
