package com.ssafy.manna.messenger.service;

import com.ssafy.manna.messenger.dto.request.NoteSendRequest;
import com.ssafy.manna.messenger.dto.request.SogaeNoteSendRequest;
import com.ssafy.manna.messenger.dto.response.NoteDetailResponse;
import com.ssafy.manna.messenger.dto.response.SogaeNoteDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    //쪽지 전송하기(일반 쪽지)
    void send(NoteSendRequest noteSendRequest) throws Exception;

    //소개팅 쪽지 전송하기
    void sendSogaeNote(SogaeNoteSendRequest sogaeNoteSendRequest) throws Exception;

    //쪽지 삭제하기
    void deleteNote(int id) throws Exception;

    //쪽지 내용 보기 (읽기처리)
    //1. 소개팅 쪽지면 소개팅 Response
    //2. 소개팅 쪽지 아니면 일반 Response
    NoteDetailResponse readDetailNote(int id) throws Exception;
    SogaeNoteDetailResponse readSogaeDetailNote(int id) throws  Exception;

}
