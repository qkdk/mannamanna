package com.ssafy.manna.global.common.dto;

import lombok.Data;

@Data
public class AddressDto {

    //시도 id
    private int sidoId;
    //구군 id
    private int gugunId;
    //상세 주소
    private String detail;
    //위도
    private double latitude;
    //경도
    private double longitude;
}
