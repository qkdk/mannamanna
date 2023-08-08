package com.ssafy.manna.messenger.repository;

import com.ssafy.manna.messenger.domain.Note;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    //id로 쪽지 조회
    Optional<Note> findById(Integer id);
    //보낸이로 쪽지 조회
    List<Note> findAllBySenderId(String SenderId);
    //받는 이로 쪽지 조회
    List<Note> findAllByReceiverId(String receiverId);

    // 내가 RECEIVER(받는 사람), isCheck=false인거
    List<Note> findAllByReceiverIdAndIsCheck(String receiverId,boolean isCheck);
}
