package com.ssafy.manna.sogaeting.service;

import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponse;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SogaetingServiceImplTest {

    @Autowired
    private SogaetingService sogaetingService;

    @Test
    public void 온라인_업데이트() {
        List<SogaetingMemberResponse> memberByCondition = sogaetingService.findMemberByCondition(
            null, null, null, null);

        long count = memberByCondition.stream()
            .filter(findMember -> findMember.getIsOnline() == null).count();

        Assertions.assertThat(count).isEqualTo(0);
    }
}