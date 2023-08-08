package com.ssafy.manna.sogaeting.service;

import com.ssafy.manna.sogaeting.dto.request.SogaetingFilteringRequest;
import com.ssafy.manna.sogaeting.dto.request.SogaetingLikeRequest;
import com.ssafy.manna.sogaeting.dto.request.SogaetingReportRequest;
import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponse;
import java.util.List;

public interface SogaetingService {

    // 신고하기
    void report(SogaetingReportRequest sogaetingReportRequest) throws Exception;

    void Like(SogaetingLikeRequest sogaetingLikeRequest) throws Exception;

    List<SogaetingMemberResponse> findMemberByCondition(
        SogaetingFilteringRequest sogaetingFilteringRequest);

    List<SogaetingMemberResponse> findMemberByConditionAndLocate(
        SogaetingFilteringRequest sogaetingFilteringRequest
    );

    List<SogaetingMemberResponse> findMemberByConditionAndOnlineState(
        SogaetingFilteringRequest sogaetingFilteringRequest
    );

    List<SogaetingMemberResponse> findMemberByConditionAndOnlineStateAndLocate(
        SogaetingFilteringRequest sogaetingFilteringRequest
    );
}
