package com.ssafy.manna.messenger.repository;

import com.ssafy.manna.messenger.domain.ChatRoom;
import com.ssafy.manna.messenger.domain.RedisChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {

}
