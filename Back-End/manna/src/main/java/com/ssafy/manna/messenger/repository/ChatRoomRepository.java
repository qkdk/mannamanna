package com.ssafy.manna.messenger.repository;

import com.ssafy.manna.messenger.dto.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {

}
