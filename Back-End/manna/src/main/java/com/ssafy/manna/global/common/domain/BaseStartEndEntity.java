package com.ssafy.manna.global.common.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseStartEndEntity {

    @CreatedDate
    private LocalDateTime startDate;
    @LastModifiedDate
    private LocalDateTime endDate;
}
