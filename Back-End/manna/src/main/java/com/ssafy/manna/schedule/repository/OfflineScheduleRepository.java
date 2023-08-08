package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.OfflineSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfflineScheduleRepository extends JpaRepository<OfflineSchedule,Integer> {
}
