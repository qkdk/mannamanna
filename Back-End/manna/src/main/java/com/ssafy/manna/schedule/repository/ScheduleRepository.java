package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {

}
