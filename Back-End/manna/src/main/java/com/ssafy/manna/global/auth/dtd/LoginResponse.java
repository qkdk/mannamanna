package com.ssafy.manna.global.auth.dtd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String id;
    private String accessToken;
    private String refreshToken;
    private String userName;
    private String gender;
}
