package com.ssafy.manna.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSignUpRequest {

    private String id;
    private String pwd;
    private String name;
    private String gender;
    private String tel;
    private String birth;
    private String emailId;
    private String emailDomain;
    private int height;
    private String job;
    private boolean isSmoker;
    private boolean isDrinker;
    private String mbti;
    private String religion;
    private String introduction;
    private boolean isBlockingFriend;

    // 추후 변경 가능성이 있는 주소 필드
    private String sido;
    private String gugun;
    private String detail;
    private Double latitude;
    private Double longitude;

}
