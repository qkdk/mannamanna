package com.ssafy.manna.messenger.domain;

import com.ssafy.manna.member.Enums.AlarmCode;
import com.ssafy.manna.global.common.domain.BaseCreateOnlyEntity;
import com.ssafy.manna.member.domain.Member;
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
public class Alarm extends BaseCreateOnlyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member receiver;

    private String content;

    @Enumerated(EnumType.STRING)
    private AlarmCode code;


}
