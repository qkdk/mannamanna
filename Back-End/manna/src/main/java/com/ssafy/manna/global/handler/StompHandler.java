package com.ssafy.manna.global.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.manna.global.auth.jwt.JwtService;
import com.ssafy.manna.messenger.domain.RedisChat;
import com.ssafy.manna.messenger.domain.RedisChatHistory;
import com.ssafy.manna.messenger.dto.ChatMessage;
import com.ssafy.manna.messenger.repository.ChatRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@Component
public class StompHandler implements ChannelInterceptor {

    private final JwtService jwtService;
    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;
    private final ChatRepository chatRepository;


    // websocket을 통해 들어온 요청이 처리 되기전 실행된다.
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor header = StompHeaderAccessor.wrap(message);

        if (StompCommand.CONNECT.equals(header.getCommand())) {
            //connect라면 name값을 꺼내서 sessionAttributes에 넣기.
            Map<String, Object> attributes = header.getSessionAttributes();
            attributes.put("userId", header.getFirstNativeHeader("userId"));
            attributes.put("userName", header.getFirstNativeHeader("userName"));
            attributes.put("gender", header.getFirstNativeHeader("gender"));
            attributes.put("token", header.getFirstNativeHeader("token"));
            header.setSessionAttributes(attributes);

//          혹시 한글 안나오면 이거 주석 해제  하세요
//            header.setNativeHeader("Content-Type", MimeTypeUtils.APPLICATION_JSON_VALUE);
//            header.setNativeHeader("charset", StandardCharsets.UTF_8.name());
        }

        try {
            ChatMessage chatMessage = encodeChatMessaege(message);
            log.info("TALK메시지 수신 " + chatMessage.getSenderId() + " : " + chatMessage.getRoomId());

            RedisChat redisChat = chatRepository.findById(chatMessage.getRoomId()).orElse(
                    new RedisChat(chatMessage.getRoomId(), new ArrayList<>()));

            redisChat.getRedisChatHistories().add(RedisChatHistory.of(chatMessage));
            chatRepository.save(redisChat);
        } catch (Exception e) {
            log.info("새로운 Socket 커넥션 확인");
        }

//        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//        // websocket 연결시 헤더의 jwt token 검증
//        if (StompCommand.CONNECT == accessor.getCommand()) {
//            jwtService.isTokenValid(accessor.getFirstNativeHeader("token"));
//        }
        return message;
    }

    private ChatMessage encodeChatMessaege(Message<?> message) throws JsonProcessingException {
        String publishMessage = (String) redisTemplate.getStringSerializer()
                .deserialize((byte[]) message.getPayload());

        return objectMapper.readValue(publishMessage, ChatMessage.class);
    }
}