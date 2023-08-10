package com.ssafy.manna.messenger.domain;

import com.ssafy.manna.global.common.domain.BaseTimeEntity;
import com.ssafy.manna.member.domain.Member;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

public class ChatRoom extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "male_id")
    private Member male;

    @ManyToOne
    @JoinColumn(name = "female_id")
    private Member female;

    private String name;
    private String lastMessage;
}
