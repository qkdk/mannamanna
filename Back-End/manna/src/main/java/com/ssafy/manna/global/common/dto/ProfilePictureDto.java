package com.ssafy.manna.global.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfilePictureDto {

    private int id;         //사진 id
    private String path;    //사진 경로
    private String name;    //사진 이름
    private int priority;   //우선순위

}
