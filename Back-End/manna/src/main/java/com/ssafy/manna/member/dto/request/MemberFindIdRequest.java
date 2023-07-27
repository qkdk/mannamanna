package com.ssafy.manna.member.dto.request;

import lombok.Data;

@Data
public class MemberFindIdRequest {
    //이름과 생년월일로 id를 찾는다
    private String name;
    private String birth;
}
