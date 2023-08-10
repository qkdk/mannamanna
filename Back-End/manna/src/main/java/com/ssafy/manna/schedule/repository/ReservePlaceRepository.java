package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.ReserveAddress;
import com.ssafy.manna.schedule.domain.ReservePlace;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservePlaceRepository extends JpaRepository<ReservePlace, Integer> {


    //reserve address id로 가져오기
    Optional<ReservePlace> findById(Integer id);
}
