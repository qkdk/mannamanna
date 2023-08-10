package com.ssafy.manna.schedule.service;

import com.ssafy.manna.schedule.domain.ReservePlace;
import org.springframework.stereotype.Service;

@Service
public interface ReservePlaceService {

    //예약 정보 조회하기
    ReservePlace getPlaceInfo(Integer id) throws  Exception;
}
