package com.ssafy.manna.schedule.service;

import com.ssafy.manna.schedule.domain.ReservePlace;
import com.ssafy.manna.schedule.repository.ReservePlaceRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReservePlaceServiceImpl implements ReservePlaceService{

    private final ReservePlaceRepository reservePlaceRepository;

    @Override
    public ReservePlace getPlaceInfo(Integer id) throws Exception {
        //id로 찾아서 
        ReservePlace reservePlace = reservePlaceRepository.findById(id).orElseThrow(()->new Exception("예약 장소 정보가 없습니다."));
        return reservePlace;
    }
}
