package com.ssafy.manna.mission.domain;

import com.ssafy.manna.mission.Enums.MissionCode;
import com.ssafy.manna.global.common.domain.BaseStartEndEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MissionQuestion extends BaseStartEndEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mission mission;

    private Integer no;
    private Boolean maleIsDone;
    private Boolean femaleIsDone;

    @Enumerated(EnumType.STRING)
    private MissionCode code;


}
