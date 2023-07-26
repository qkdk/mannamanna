package com.ssafy.manna.domain.schedule.domain;

import com.ssafy.manna.domain.member.domain.Member;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {


    @EmbeddedId
    private ScheduleId id;

    @MapsId("memberId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member opponent;

    private LocalDateTime date;

}
