package com.ssafy.manna.domain.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BalanceGame {

    @Id
    private String question;

    private Integer level;

}
