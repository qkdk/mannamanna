package com.ssafy.manna.domain.member.domain;

import com.ssafy.manna.global.common.domain.BaseTimeEntity;
import com.ssafy.manna.global.common.domain.Gugun;
import com.ssafy.manna.global.common.domain.Sido;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
public class Address extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    private Sido sido;

    @OneToOne(fetch = FetchType.LAZY)
    private Gugun gugun;

    private String detail;

    private Double latitude;
    private Double longitude;

}
