package com.ssafy.manna.global.handler;

import static org.junit.jupiter.api.Assertions.*;

import com.ssafy.manna.messenger.domain.RedisChat;
import com.ssafy.manna.messenger.repository.ChatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StompHandlerTest {

    @Autowired
    private ChatRepository chatRepository;

    @Test
    public void AA(){
        RedisChat redisChat = chatRepository.findById("4").get();
        for (RedisChatElement redisChatElement : redisChat.getRedisChatElements()) {
            System.out.println(redisChatElement);
        }
    }
}