package com.ssafy.manna.messenger.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedisChatRoom implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    private String roomId;
    private String name;

    public static RedisChatRoom of(ChatRoom chatRoom) {
        RedisChatRoom redisChatRoom = new RedisChatRoom();
        redisChatRoom.roomId = chatRoom.getId().toString();
        redisChatRoom.name = chatRoom.getName();
        return redisChatRoom;
    }
}