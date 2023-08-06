package com.ssafy.manna.messenger.domain;

import com.ssafy.manna.member.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member sender;

    private String subject;

    private String content;

    private LocalDateTime date;

    private Boolean isSogae;

    private Boolean isCheck;

    private Boolean isReject;

}