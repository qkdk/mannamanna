package com.ssafy.manna.global.util;

import com.ssafy.manna.global.common.domain.Session;
import com.ssafy.manna.global.common.repository.RedisSessionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SessionUtil {

    private final RedisSessionRepository redisSessionRepository;

    // 모든 접속 유저를 가져오는 기능
    public List<Session> findOnlineMembers(){
        return redisSessionRepository.findAll();
    }

    // id에 해당하는 유저가 접속중인지 확인하는 기능
    public Boolean checkMemberIsOnline(String userId){
        return redisSessionRepository.findById(userId).isPresent();
    }

    // 남자만 가져오는 기능
    public List<Session> findOnlineMaleMember(){
        return redisSessionRepository.findSessionByGender("male");
    }

    // 여자만 가져오는 기능
    public List<Session> findOnlineFemaleMember(){
        return redisSessionRepository.findSessionByGender("female");
    }
}
