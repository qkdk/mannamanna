package com.ssafy.manna.messenger.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteSendRequest {
    //새 쪽지 쓰기

    //받는이
    private String receiver;
    //보낸이
    private String sender;
    //제목
    private String subject;
    //내용
    private String content;
    //소개팅 신청 여부
    private boolean isSogae;
    //소개팅 신청 시간
    private LocalDateTime date;
}
