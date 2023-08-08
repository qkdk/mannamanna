package com.ssafy.manna.sogaeting.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.ssafy.manna.sogaeting.dto.response.SogeatingPeopleResponse;
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
        List<SogeatingPeopleResponse> sample = customSogaetingRepository.sample(null, null, null,
            null);

        for (SogeatingPeopleResponse sogeatingPeopleResponse : sample) {
            System.out.println(sogeatingPeopleResponse);
        }
    }
}