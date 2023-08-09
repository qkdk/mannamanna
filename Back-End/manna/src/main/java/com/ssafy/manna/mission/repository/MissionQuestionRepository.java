package com.ssafy.manna.mission.repository;

import com.ssafy.manna.mission.domain.Mission;
import com.ssafy.manna.mission.domain.MissionQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionQuestionRepository extends JpaRepository<MissionQuestion, String> {

    // 해당하는 회원의 미션정보 불러오기
    List<MissionQuestion> findByMissionIn(List<Mission> missions);
}
