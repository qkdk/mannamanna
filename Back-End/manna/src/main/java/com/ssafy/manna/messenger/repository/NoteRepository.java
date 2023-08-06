package com.ssafy.manna.messenger.repository;

import com.ssafy.manna.messenger.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    //id로 쪽지 조회
    Optional<Note> findById(Integer id);

    //보낸이로 쪽지 조회

    //받는 이로 쪽지 조회

    //읽음 여부로 쪽지 조회
}
