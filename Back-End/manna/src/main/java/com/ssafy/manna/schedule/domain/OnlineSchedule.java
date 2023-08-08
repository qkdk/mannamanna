package com.ssafy.manna.schedule.domain;

import com.ssafy.manna.member.domain.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@DiscriminatorValue("Online")
public class OnlineSchedule extends Schedule {
    @Column(name="url")
    private String url;

    // 슈퍼 빌더를 사용하여 부모 클래스의 빌더를 활용합니다.
    @Builder
    public OnlineSchedule( Member member, Member opponent, LocalDateTime date, String url) {
        super(member, opponent, date);
        this.url = url;
    }
}
