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
    private ReserveAddress reserve;

    @Builder
    public OfflineSchedule(Member member, Member opponent, LocalDateTime date,  ReserveAddress reserve) {
        super( member, opponent, date);
        this.reserve = reserve;
    }

}
