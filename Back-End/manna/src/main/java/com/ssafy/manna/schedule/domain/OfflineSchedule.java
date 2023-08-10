package com.ssafy.manna.schedule.domain;

import com.ssafy.manna.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DiscriminatorValue("Offline")
public class OfflineSchedule extends Schedule {

    @OneToOne(fetch = FetchType.LAZY)
    private ReservePlace reserve;

    @Builder
    public OfflineSchedule(Member female, Member male, LocalDateTime date,  ReservePlace reserve) {
        super(female, male, date);
        this.reserve = reserve;
    }

}
