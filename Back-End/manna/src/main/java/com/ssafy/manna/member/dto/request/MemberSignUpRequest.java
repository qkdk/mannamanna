package com.ssafy.manna.member.dto.request;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.domain.MemberDetail;
import com.ssafy.manna.member.domain.ProfilePicture;
import lombok.Builder;
import lombok.Data;

@Data
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


}
