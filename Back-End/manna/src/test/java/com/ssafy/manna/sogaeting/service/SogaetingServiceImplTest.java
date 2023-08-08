package com.ssafy.manna.sogaeting.service;

import com.ssafy.manna.global.common.domain.Session;
import com.ssafy.manna.global.common.repository.RedisSessionRepository;
import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponse;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SogaetingServiceImplTest {

    @Autowired
    private SogaetingService sogaetingService;
    @Autowired
    private RedisSessionRepository redisSessionRepository;


    @BeforeEach
    public void before() {
        Session test1 = Session.builder()
            .userName("test1")
            .userId("test1")
            .gender("M")
            .offset(3)
            .build();

        Session test2 = Session.builder()
            .userName("test2")
            .userId("test2")
            .gender("F")
            .offset(4)
            .build();

        redisSessionRepository.save(test1);
        redisSessionRepository.save(test2);
    }

    @AfterEach
    public void after() {
        redisSessionRepository.deleteById("test1");
        redisSessionRepository.deleteById("test2");
    }

    @Test
    public void 온라인_업데이트() {
        List<SogaetingMemberResponse> memberByCondition1 = sogaetingService.findMemberByCondition(
            null, null, null, null, null, "test1");
        List<SogaetingMemberResponse> memberByCondition2 = sogaetingService.findMemberByCondition(
            null, null, null, null, null, "test2");

        Assertions.assertThat(memberByCondition1.get(0).getId())
            .isNotEqualTo(memberByCondition2.get(0).getId());
    }
}