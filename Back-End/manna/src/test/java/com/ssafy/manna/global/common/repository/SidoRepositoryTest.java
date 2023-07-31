package com.ssafy.manna.global.common.repository;

import com.ssafy.manna.global.common.domain.Sido;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class SidoRepositoryTest {

    @Autowired
    private SidoRepository sidoRepository;

    @Test
    public void 시도_조회_테스트() {
        Sido sido = sidoRepository.findByName("서울").get();

        Assertions.assertThat(sido.getName()).isEqualTo("서울");
    }
}