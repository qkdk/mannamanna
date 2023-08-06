package com.ssafy.manna.sogaeting.controller;

import com.ssafy.manna.global.util.ResponseTemplate;
import com.ssafy.manna.sogaeting.dto.request.SogaetingReportRequest;
import com.ssafy.manna.sogaeting.service.SogaetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
@EnableWebMvc
@Slf4j
@RequestMapping("/api/sogaeting")
public class SogaetingController {

    private final SogaetingService sogaetingService;

    // 신고하기
    @PostMapping(value = "/report")
    public ResponseEntity<?> report(@RequestBody SogaetingReportRequest sogaetingReportRequest){
        ResponseTemplate<?> body;
        try{
            sogaetingService.report(sogaetingReportRequest);
            return ResponseEntity.ok("report success");
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
