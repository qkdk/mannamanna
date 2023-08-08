package com.ssafy.manna.sogaeting.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class SogaetingPictureDto {
    private String path;

    @QueryProjection
    public SogaetingPictureDto(String path) {
        this.path = path;
    }
}
