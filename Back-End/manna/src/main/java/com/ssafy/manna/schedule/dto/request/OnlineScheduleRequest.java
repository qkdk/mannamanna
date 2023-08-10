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

    //여자 id
    private Member female;
    //남자 id
    private Member male;
    //시간
    private LocalDateTime date;
    //url
    private String url;
}
