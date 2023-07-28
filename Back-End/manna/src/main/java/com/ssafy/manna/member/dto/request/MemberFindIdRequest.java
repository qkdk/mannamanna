package com.ssafy.manna.member.dto.request;

import lombok.Data;

@Data
public class MemberFindIdRequest {
    private String emailId;
    private String emailDomain;
}
