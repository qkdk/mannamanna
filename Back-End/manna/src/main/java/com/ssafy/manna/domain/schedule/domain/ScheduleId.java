package com.ssafy.manna.domain.schedule.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ScheduleId implements Serializable {

    private Integer id;

    private String memberId;

}
