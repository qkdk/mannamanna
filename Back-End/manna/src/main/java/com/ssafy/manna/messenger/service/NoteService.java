package com.ssafy.manna.messenger.service;

import com.ssafy.manna.messenger.dto.request.NoteSendRequest;
import org.springframework.stereotype.Service;

@Service
public interface NoteService {

    //쪽지 전송하기
    void send(NoteSendRequest noteSendRequest) throws Exception;


}
