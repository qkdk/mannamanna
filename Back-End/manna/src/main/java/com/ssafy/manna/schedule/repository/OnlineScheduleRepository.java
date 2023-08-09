package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.OnlineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OnlineScheduleRepository extends JpaRepository<OnlineSchedule,Integer> {

//    @Override
//    Optional<OnlineSchedule> findById(Integer integer);
    List<OnlineSchedule> findByFemale(String femaleId);
    List<OnlineSchedule> findByMale(String maleId);
}
