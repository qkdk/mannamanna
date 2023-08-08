package com.ssafy.manna.sogaeting.service;

import com.ssafy.manna.sogaeting.dto.request.SogaetingLikeRequest;
import com.ssafy.manna.sogaeting.dto.request.SogaetingReportRequest;

public interface SogaetingService {

    // 신고하기
    void report(SogaetingReportRequest sogaetingReportRequest) throws Exception;

    void Like(SogaetingLikeRequest sogaetingLikeRequest) throws Exception;
}
