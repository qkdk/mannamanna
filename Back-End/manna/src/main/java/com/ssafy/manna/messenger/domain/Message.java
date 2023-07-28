package com.ssafy.manna.messenger.domain;

import com.ssafy.manna.member.domain.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private MessageRoom messageRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member receiver;

    private String content;

    private LocalDateTime date;

    private Boolean isRead;
}
