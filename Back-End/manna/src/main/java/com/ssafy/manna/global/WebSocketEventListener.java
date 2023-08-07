package com.ssafy.manna.global;

import com.ssafy.manna.global.common.domain.Session;
import com.ssafy.manna.global.common.repository.RedisSessionRepository;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final RedisSessionRepository redisSessionRepository;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        try {
            String userName = headerAccessor.getNativeHeader("userName").get(0);
            String gender = headerAccessor.getNativeHeader("gender").get(0);
            String userId = headerAccessor.getNativeHeader("userId").get(0);
            headerAccessor.getSessionAttributes().put("userId", userId);

            saveSession(userName, gender, userId);
        } catch (Exception e) {

        }

    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String userId = (String) headerAccessor.getSessionAttributes().get("userId");
        redisSessionRepository.deleteById(userId);
    }

    private void saveSession(String userName, String gender, String userId) {
        Session socketSession = Session.builder()
            .gender(gender)
            .userId(userId)
            .userName(userName)
            .build();
        redisSessionRepository.save(socketSession);
    }
}
