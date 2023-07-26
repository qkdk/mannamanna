package com.ssafy.manna.domain.member.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ScheduleId implements Serializable {

    private Integer id;

    private String memberId;

}
