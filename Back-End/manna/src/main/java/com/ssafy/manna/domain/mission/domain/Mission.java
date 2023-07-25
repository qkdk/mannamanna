package com.ssafy.manna.domain.mission.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Mission {

    @Id
    @GeneratedValue
    private Long id;
}
