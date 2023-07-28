package com.ssafy.manna.member.dto.request;

import lombok.Data;
import lombok.Getter;

@Data
public class MemberLoginRequest {

    private String id;
    private String pwd;
}
