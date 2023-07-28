package com.ssafy.manna.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberLoginResponse {

    private String accessToken;
    private String role;
    private String id;


}
