package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.OfflineSchedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfflineScheduleRepository extends JpaRepository<OfflineSchedule,Integer> {
    //    @Override
//    Optional<OnlineSchedule> findById(Integer integer);
    List<OfflineSchedule> findByFemaleId(String femaleId);
    List<OfflineSchedule> findByMaleId(String maleId);
}
