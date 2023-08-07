package com.ssafy.manna.messenger.service;

import com.ssafy.manna.messenger.dto.request.NoteSendRequest;
import com.ssafy.manna.messenger.dto.request.SogaeNoteSendRequest;
import com.ssafy.manna.messenger.dto.response.NoteDetailResponse;
import com.ssafy.manna.messenger.dto.response.NoteListResponse;
import com.ssafy.manna.messenger.dto.response.ReceivedNoteResponse;
import com.ssafy.manna.messenger.dto.response.SentNoteResponse;
import com.ssafy.manna.messenger.dto.response.SogaeNoteDetailResponse;
import java.util.List;
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

    //받은 쪽지 List 반환
    List<NoteListResponse> receivedNoteList(String userId) throws Exception;

    //보낸 쪽지 List 반환
    List<NoteListResponse> sentNoteList(String userId) throws Exception;


}
