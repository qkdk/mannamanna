package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.OnlineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineScheduleRepository extends JpaRepository<OnlineSchedule,Integer> {

}
