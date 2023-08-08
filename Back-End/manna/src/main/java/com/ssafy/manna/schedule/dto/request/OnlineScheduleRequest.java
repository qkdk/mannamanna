package com.ssafy.manna.schedule.dto.request;

import java.time.LocalDateTime;
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
    String memberId;
    //상대방 id
    String opponentId;
    //url : 소개팅 방 url
    String url;
    //시간
    LocalDateTime date;

}
