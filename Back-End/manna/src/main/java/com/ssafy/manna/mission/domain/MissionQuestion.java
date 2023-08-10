package com.ssafy.manna.mission.domain;

import com.ssafy.manna.mission.Enums.MissionCode;
import com.ssafy.manna.global.common.domain.BaseStartEndEntity;
import com.ssafy.manna.mission.dto.request.MissionDoRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class MissionQuestion extends BaseStartEndEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mission mission;

    private Boolean maleIsDone;
    private Boolean femaleIsDone;

    @Enumerated(EnumType.STRING)
    private MissionCode code;

    private String content;

    private String maleImagePath;

    private String femaleImagePath;


    public void updateMaleImgPath(String maleImagePath) {
        this.maleImagePath = maleImagePath;
    }

    public void updateFemaleImgPath(String femaleImagePath) {
        this.femaleImagePath = femaleImagePath;
    }

    public void updateMaleIsDone(Boolean maleIsDone){
        this.maleIsDone = maleIsDone;
    }

    public void updateFemaleIsDone(Boolean FemaleIsDone){
        this.femaleIsDone = femaleIsDone;
    }

}
