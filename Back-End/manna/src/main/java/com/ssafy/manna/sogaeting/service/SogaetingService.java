package com.ssafy.manna.sogaeting.service;

import com.ssafy.manna.sogaeting.dto.request.*;
import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponse;
import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponsePage;
import java.util.List;

public interface SogaetingService {

    // 신고하기
    void report(SogaetingReportRequest sogaetingReportRequest) throws Exception;

    void Like(SogaetingLikeRequest sogaetingLikeRequest) throws Exception;

    SogaetingMemberResponsePage findMemberByCondition(
        SogaetingFilteringRequest sogaetingFilteringRequest);

    SogaetingMemberResponsePage findMemberByConditionAndLocate(
        SogaetingFilteringRequest sogaetingFilteringRequest
    );

    SogaetingMemberResponsePage findMemberByConditionAndOnlineState(
        SogaetingFilteringRequest sogaetingFilteringRequest
    );

    SogaetingMemberResponsePage findMemberByConditionAndOnlineStateAndLocate(
        SogaetingFilteringRequest sogaetingFilteringRequest
    );

    // 소개팅 시작하기
    void start(SogaetingStartRequest sogaetingStartRequest);

    void success(SogaetingSuccessRequest sogaetingSuccessRequest);
}
