package com.ssafy.manna.messenger.domain;

import com.ssafy.manna.global.handler.RedisChatElement;
import com.ssafy.manna.messenger.dto.ChatMessage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Getter
@Builder
@AllArgsConstructor
@ToString
public class RedisChat {

    @Id
    private String roomId;
    private List<RedisChatElement> redisChatElements;

}

