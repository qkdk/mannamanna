package com.ssafy.manna.schedule.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@DiscriminatorValue("Offline")
public class OfflineSchedule extends Schedule {

    @OneToOne(fetch = FetchType.LAZY)
    private ReserveAddress reserve;

}
