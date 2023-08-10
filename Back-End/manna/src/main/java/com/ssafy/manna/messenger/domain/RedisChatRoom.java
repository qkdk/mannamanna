package com.ssafy.manna.messenger.domain;

import com.ssafy.manna.messenger.dto.request.MakeChattingRoomRequest;
import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedisChatRoom implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    private String roomId;
    private String name;

    public static RedisChatRoom create(ChatRoom chatRoom) {
        RedisChatRoom redisChatRoom = new RedisChatRoom();
        redisChatRoom.roomId = chatRoom.getId().toString();
        redisChatRoom.name = chatRoom.getName();
        return redisChatRoom;
    }
}