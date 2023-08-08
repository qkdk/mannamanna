package com.ssafy.manna.mission.repository;

import com.ssafy.manna.mission.domain.MissionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionQuestionRepository extends JpaRepository<MissionQuestion, String> {
}
