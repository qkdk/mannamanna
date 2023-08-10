package com.ssafy.manna.schedule.controller;

import com.ssafy.manna.schedule.service.ReservePlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
@EnableWebMvc
@Slf4j
@RequestMapping("/api/reserve")
public class ReservePlaceController {

    private final ReservePlaceService reservePlaceService;
    //예약하기 - 조회
    @GetMapping("/{reserveId}")
    public ResponseEntity<?> reservePlace(@PathVariable("reserveId") Integer reserveId ){
        try {
//            reservePlaceService.reserve(reserveId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //예약
}
