package com.ssafy.manna.messenger.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDetailResponse {
    //받는이
    private String receiver;
    //보내는이
    private String sender;
    //쪽지 아이디
    private int id;
    //쪽지 제목
    private String subject;
    //쪽지를 보낸시간
    private LocalDateTime date;
    //소개팅 쪽지 여부
    private boolean isSogae;
    //소개팅 수락 여부
    private boolean isReject;
    //읽음 여부
    private boolean isCheck;
    //내용
    private String content;
}
