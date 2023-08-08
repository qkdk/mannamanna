package com.ssafy.manna.sogaeting.repository;

import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponse;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomSogaetingRepositoryTest {

    @Autowired
    private CustomSogaetingRepository customSogaetingRepository;

    @Test
    public void 테스트(){
        List<SogaetingMemberResponse> sample = customSogaetingRepository.findMemberByCondition(null, null, null,
            null);

        for (SogaetingMemberResponse sogaetingMemberResponse : sample) {
            System.out.println(sogaetingMemberResponse);
        }
    }
}