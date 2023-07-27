package com.ssafy.manna.member.dto.request;

import com.ssafy.manna.global.common.dto.AddressDto;
import lombok.Data;

@Data
public class MemberUpdateRequest {

    //유저 이름
    private String name;
    //주소
    private AddressDto addressDto;

    //유저 마일리지
    private int mileage;

    //유저 mbti
    private String mbti;

    //흡연여부
    private boolean isSmoker;

    //음주여부
    private boolean isDrinker;

    //종교
    private String religion;

    //자기소개
    private String introduction;

    ///지인차단여부
    private boolean isBlockingFriend;

}
