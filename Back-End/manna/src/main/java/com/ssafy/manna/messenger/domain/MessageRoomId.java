package com.ssafy.manna.messenger.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.io.Serializable;
import lombok.Setter;

@Embeddable
public class MessageRoomId implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ownerId;
}
