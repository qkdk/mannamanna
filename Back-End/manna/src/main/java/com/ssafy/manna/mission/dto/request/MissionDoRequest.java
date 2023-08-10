package com.ssafy.manna.mission.dto.request;

import lombok.*;

@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class MissionDoRequest {

    private String memberId;
    private int id;
    private String gender;
    //private String path;

}
