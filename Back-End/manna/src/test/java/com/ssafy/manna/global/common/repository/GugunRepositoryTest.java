package com.ssafy.manna.global.common.repository;

import com.ssafy.manna.global.common.domain.Gugun;
import com.ssafy.manna.global.common.domain.Sido;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class GugunRepositoryTest {

    @Autowired
    private GugunRepository gugunRepository;
    @Autowired
    private SidoRepository sidoRepository;

    @Test
    public void 구군_조회_테스트() {
        Sido sido = sidoRepository.findByName("서울특별시").get();

        Gugun gugun = gugunRepository.findByNameAndSido("강남구", sido).get();

        Assertions.assertThat(gugun.getName()).isEqualTo("강남구");
    }
}