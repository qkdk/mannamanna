package com.ssafy.manna.messenger.controller;

import com.ssafy.manna.global.util.ResponseTemplate;
import com.ssafy.manna.messenger.domain.RedisChatRoom;
import com.ssafy.manna.messenger.dto.request.MakeChattingRoomRequest;
import com.ssafy.manna.messenger.dto.response.ChatRoomResponse;
import com.ssafy.manna.messenger.service.ChatRoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/room/{userId}")
//    public RedisChatRoom findRoomsById(@PathVariable String userId) {
//        return chatRoomService.findRoomById(userId);
//    }

    @GetMapping("/room/{userId}")
    public ResponseEntity<ResponseTemplate<List<ChatRoomResponse>>> findRoomsById(
        @PathVariable String userId) {

        return new ResponseEntity<>(
            ResponseTemplate.<List<ChatRoomResponse>>builder()
                .result(true)
                .msg("채팅방 러오기 성공")
                .data(chatRoomService.findChatRoomById(userId))
                .build(),
            HttpStatus.OK
        );
    }
}