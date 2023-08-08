package com.ssafy.manna.mission.repository;

import com.ssafy.manna.global.common.domain.CodeDetail;
import com.ssafy.manna.mission.domain.Mission;
import com.ssafy.manna.mission.service.MissionServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Optional<Mission> findById(int id);
}
