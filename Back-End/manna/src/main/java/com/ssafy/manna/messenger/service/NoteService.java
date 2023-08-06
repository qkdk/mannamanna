package com.ssafy.manna.messenger.service;

import com.ssafy.manna.messenger.dto.request.NoteSendRequest;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    //쪽지 전송하기
    void send(NoteSendRequest noteSendRequest) throws Exception;

    //쪽지 삭제하기
    void deleteNote(int id) throws Exception;



}
