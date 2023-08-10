package com.ssafy.manna.messenger.service;

import static org.junit.jupiter.api.Assertions.*;

import com.ssafy.manna.messenger.dto.response.ChatRoomResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatRoomServiceTest {

    @Autowired
    private ChatRoomService chatRoomService;

    @Test
    public void 채팅방_정보_테스트(){
        String femaleId = "sohyun1";

        List<ChatRoomResponse> chatRoomById = chatRoomService.findChatRoomById(femaleId);
        System.out.println(chatRoomById);
    }

}