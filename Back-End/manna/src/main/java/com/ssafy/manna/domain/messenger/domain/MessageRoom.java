package com.ssafy.manna.domain.messenger.domain;


import com.ssafy.manna.domain.member.domain.Member;
import com.ssafy.manna.global.common.domain.BaseTimeEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageRoom extends BaseTimeEntity {

    @EmbeddedId
    private MessageRoomId id;

    @MapsId("ownerId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member owner;

    private String name;
    private String headMessage;

}
