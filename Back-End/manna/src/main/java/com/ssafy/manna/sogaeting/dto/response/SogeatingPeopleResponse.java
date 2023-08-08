package com.ssafy.manna.sogaeting.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class SogeatingPeopleResponse {

    private String id;
    private String name;
    private String birth;
    private String sido;
    private String mbti;
    private String religion;
    private String introduction;
    private Boolean isSmoke;
    private Boolean isDrink;
    private Boolean isOnline;
    private String pictureURL;

    public void updateOnlineState(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    @QueryProjection
    public SogeatingPeopleResponse(String id, String name, String birth, String sido, String mbti,
        String religion, String introduction, Boolean isSmoke, Boolean isDrink,
        String pictureURL) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.sido = sido;
        this.mbti = mbti;
        this.religion = religion;
        this.introduction = introduction;
        this.isSmoke = isSmoke;
        this.isDrink = isDrink;
        this.pictureURL = pictureURL;
    }
}
