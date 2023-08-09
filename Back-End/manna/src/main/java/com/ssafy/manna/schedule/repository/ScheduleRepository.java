package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.OnlineSchedule;
import com.ssafy.manna.schedule.domain.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    List<OnlineSchedule> findByFemale(String femaleId);
    List<OnlineSchedule> findByMale(String maleId);
//    List<OnlineSchedule> findAllByMemberId(String memberId);
//    void deleteById(Integer id);
//
//    //memberId, opponentId, date로 찾기
//    Schedule findByMemberIdAndOpponentIdAndDate(String memberId, String opponentId,
//            LocalDateTime date);

//    @Query("SELECT s FROM Schedule s LEFT JOIN OnlineSchedule os ON s.id = os.id WHERE s.id = :id")
//    Schedule findScheduleWithOnlineScheduleById(@Param("id") Integer id);
}
