package com.ssafy.manna.schedule.repository;

import com.ssafy.manna.schedule.domain.OnlineSchedule;
import com.ssafy.manna.schedule.domain.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    List<OnlineSchedule> findAllByMemberId(String memberId);
    void deleteById(Integer id);

    //memberId, opponentId, date로 찾기
    Schedule findByMemberIdAndOpponentIdAndDate(String memberId, String opponentId,
            LocalDateTime date);
}
