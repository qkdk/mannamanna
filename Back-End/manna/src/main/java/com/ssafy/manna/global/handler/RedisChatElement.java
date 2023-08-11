package com.ssafy.manna.global.handler;

import com.ssafy.manna.messenger.domain.RedisChat;
import com.ssafy.manna.messenger.dto.ChatMessage;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class RedisChatElement implements Serializable {
    private String senderId;
    private String senderName;
    private String message;
    private LocalDateTime time;

    public static RedisChatElement of (ChatMessage roomMessage){
        return RedisChatElement.builder()
            .message(roomMessage.getMessage())
            .senderId(roomMessage.getSenderId())
            .senderName(roomMessage.getSenderName())
            .time(LocalDateTime.now())
            .build();
    }
}
