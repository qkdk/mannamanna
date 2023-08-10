package com.ssafy.manna.messenger.controller;

import com.ssafy.manna.messenger.domain.RedisChatRoom;
import com.ssafy.manna.messenger.dto.request.MakeChattingRoomRequest;
import com.ssafy.manna.messenger.service.ChatRoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;


    @GetMapping("/rooms")
    public List<RedisChatRoom> room() {
        return chatRoomService.findAllRoom();
    }


    // 상대방 아이디와 자신의 아이디가 필요하다.

    @PostMapping("/room")
    public RedisChatRoom createRoom(@RequestBody MakeChattingRoomRequest makeChattingRoomRequest) {
        // 방정보를 리턴한다.
        return chatRoomService.createChatRoom(makeChattingRoomRequest);
    }

//    @PostMapping("/room")
//    public ChatRoom createRoom(@RequestParam String name) {
//        // 방정보를 리턴한다.
//        return chatRoomRepository.createChatRoom(name);
//    }

    @GetMapping("/room/{roomId}")
    public RedisChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomService.findRoomById(roomId);
    }
}