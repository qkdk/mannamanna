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
public class SogaeNoteSendRequest {
    // 소개팅 쪽지
    //받는이 - 이름
    private String receiver;

    //보내는이 - 이름
    private String sender;

    //date 날짜
    private String date;

 }
