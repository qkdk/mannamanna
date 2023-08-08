package com.ssafy.manna.schedule.dto.request;

import java.time.LocalDateTime;

import com.ssafy.manna.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OnlineScheduleRequest {

    //내 id
    private Member member;
    //상대방 id
    private Member opponent;
    //시간
    private LocalDateTime date;
    //url
    private String url;
}
