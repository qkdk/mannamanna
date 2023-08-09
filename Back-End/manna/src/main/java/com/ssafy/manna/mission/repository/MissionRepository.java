package com.ssafy.manna.mission.repository;

import com.ssafy.manna.mission.domain.Mission;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, String> {

    Optional<Mission> findById(int id);

    @Query("SELECT m FROM Mission m WHERE m.maleId = :id")
    List<Mission> findByMaleId(@Param("id") String id);

    @Query("SELECT m FROM Mission m WHERE m.femaleId = :id")
    List<Mission> findByFemaleId(@Param("id") String id);
}
