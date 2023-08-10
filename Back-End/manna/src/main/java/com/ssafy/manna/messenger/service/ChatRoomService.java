package com.ssafy.manna.messenger.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.messenger.domain.ChatRoom;
import com.ssafy.manna.messenger.domain.RedisChatRoom;
import com.ssafy.manna.messenger.dto.request.MakeChattingRoomRequest;
import com.ssafy.manna.messenger.repository.ChatRoomRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    // Redis
    private static final String CHAT_ROOMS = "CHAT_ROOM";
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;
    private HashOperations<String, String, RedisChatRoom> opsHashChatRoom;

    @PostConstruct
    private void init() {
        opsHashChatRoom = redisTemplate.opsForHash();
    }

    // 모든 채팅방 조회
    public List<RedisChatRoom> findAllRoom() {
        return opsHashChatRoom.values(CHAT_ROOMS);
    }

    // 특정 채팅방 조회
    public RedisChatRoom findRoomById(String id) {
        return opsHashChatRoom.get(CHAT_ROOMS, id);
    }

    // 채팅방 생성 : 서버간 채팅방 공유를 위해 redis hash에 저장한다.
    public RedisChatRoom createChatRoom(MakeChattingRoomRequest makeChattingRoomRequest) {
        ChatRoom chatRoom = saveChatRoom(makeChattingRoomRequest);

        RedisChatRoom redisChatRoom = RedisChatRoom.of(chatRoom);

        opsHashChatRoom.put(CHAT_ROOMS, redisChatRoom.getRoomId(), redisChatRoom);
        return redisChatRoom;
    }

    private ChatRoom saveChatRoom(MakeChattingRoomRequest makeChattingRoomRequest) {
        Member female = memberRepository.findById(makeChattingRoomRequest.getFemaleId())
            .orElseThrow(() -> new RuntimeException("일치하는 여자 회원이 없습니다."));

        Member male = memberRepository.findById(makeChattingRoomRequest.getMaleId())
            .orElseThrow(() -> new RuntimeException("일치하는 남자 회원이 없습니다."));

        ChatRoom chatRoom = ChatRoom.of(male, female);

        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }
}