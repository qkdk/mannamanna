package com.ssafy.manna.member.dto.response;

import com.ssafy.manna.global.common.dto.AddressDto;
import lombok.Data;

@Data
public class MemberInfoResponse {
    //마이페이지 - 조회 Response

//    이름
    private String name;
//     지역
    private AddressDto address;
//    마일리지
    private int mileage;
//    프로필사진
    private String profilePath;
//    직업
    private String job;
//            키
    private int height;
//    흡연
    private boolean isSmoker;
//            음주
    private boolean isDrinker;
//    mbti
    private String mbti;
//            종교
    private String religion;
//    자기소개
    private String introduction;

    // 지인차단여부
    private boolean isBlockingFriend;

}
