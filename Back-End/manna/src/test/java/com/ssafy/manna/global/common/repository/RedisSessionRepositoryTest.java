package com.ssafy.manna.global.common.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.ssafy.manna.global.common.domain.Session;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class RedisSessionRepositoryTest {

    @Autowired
    private RedisSessionRepository redisSessionRepository;

    @Test
    public void 세션_저장_테스트() {
        Session session = makeEntity();

        redisSessionRepository.save(session);
        Session findSession = redisSessionRepository.findById("testId").get();

        Assertions.assertThat(session.getUserId()).isEqualTo(findSession.getUserId());
        redisSessionRepository.deleteById("testId");
    }

    @Test
    public void 세션_삭제_테스트() {
        Session session = makeEntity();

        redisSessionRepository.save(session);
        redisSessionRepository.deleteById("testId");

        Assertions.assertThat(redisSessionRepository.findById("testId").isEmpty()).isTrue();
    }


    private static Session makeEntity() {
        Session session = Session.builder()
            .userId("testId")
            .userName("testName")
            .gender("testGender")
            .build();
        return session;
    }

}