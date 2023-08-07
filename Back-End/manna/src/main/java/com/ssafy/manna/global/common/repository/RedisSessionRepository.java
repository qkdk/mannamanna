package com.ssafy.manna.global.common.repository;

import com.ssafy.manna.global.common.domain.Session;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RedisSessionRepository extends CrudRepository<Session, String> {

    @Override
    void deleteById(String userId);

    @Override
    List<Session> findAll();
}
