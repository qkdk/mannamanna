package com.ssafy.manna.schedule.domain;

import com.ssafy.manna.member.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Getter
//@AllArgsConstructor
public class OnlineSchedule extends Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

//    public OnlineSchedule(ScheduleId id, Member member,
//            Member opponent, LocalDateTime date, Integer onlineId,
//            String url) {
//        super(id, member, opponent, date);
//        this.id = onlineId;
//        this.url = url;
//    }
}
