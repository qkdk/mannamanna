package com.ssafy.manna.global.common.domain;

import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseStartEndEntity {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
