package com.ssafy.manna.global.common.repository;

import com.ssafy.manna.global.common.domain.Sido;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SidoRepository extends JpaRepository<Sido, Integer> {

    Optional<Sido> findByName(String name);

    @Override
    Optional<Sido> findById(Integer integer);
}
