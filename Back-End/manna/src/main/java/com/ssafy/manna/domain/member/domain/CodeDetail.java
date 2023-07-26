package com.ssafy.manna.domain.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CodeDetail {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Code code;
    private String name;

}
