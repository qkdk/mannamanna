package com.ssafy.manna.messenger.repository;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.messenger.domain.ChatRoom;
import com.ssafy.manna.messenger.domain.RedisChatRoom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {

    List<ChatRoom> findByFemale(Member female);

    List<ChatRoom> findByMale(Member male);

}
