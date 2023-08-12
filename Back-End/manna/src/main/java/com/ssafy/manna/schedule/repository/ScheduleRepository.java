package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    List<Schedule> findByFemaleId(String femaleId);
    List<Schedule> findByMaleId(String maleId);


}
