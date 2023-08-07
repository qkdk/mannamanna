package com.ssafy.manna.global.common.service;

import static com.ssafy.manna.global.common.enums.SessionEnum.*;

import com.ssafy.manna.global.common.domain.Session;
import com.ssafy.manna.global.common.repository.RedisSessionRepository;
import com.ssafy.manna.global.common.enums.SessionEnum;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SessionService {

    private final RedisSessionRepository redisSessionRepository;

    // 모든 접속 유저를 가져오는 기능
    public List<Session> findOnlineMembers() {
        return redisSessionRepository.findAll();
    }

    // id에 해당하는 유저가 접속중인지 확인하는 기능
    public Boolean checkMemberIsOnline(String userId) {
        return redisSessionRepository.findById(userId).isPresent();
    }

    // 남자만 가져오는 기능
    public List<Session> findOnlineMaleMember() {
        List<Session> allSession = redisSessionRepository.findAll();
        return allSession.stream()
            .filter(session -> session.getGender().equals(GENDER_MALE.getValue()))
            .toList();
    }

    // 여자만 가져오는 기능
    public List<Session> findOnlineFemaleMember() {
        List<Session> allSession = redisSessionRepository.findAll();
        return allSession.stream()
            .filter(session -> session.getGender().equals(GENDER_FEMALE.getValue()))
            .toList();
    }
}
