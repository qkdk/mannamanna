package com.ssafy.manna.messenger.controller;

import com.ssafy.manna.global.util.ResponseTemplate;
import com.ssafy.manna.messenger.domain.Note;
import com.ssafy.manna.messenger.dto.request.NoteSendRequest;
import com.ssafy.manna.messenger.repository.NoteRepository;
import com.ssafy.manna.messenger.service.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
@EnableWebMvc
@Slf4j
@RequestMapping("/api/note")
public class NoteController {

    private final NoteService noteService;

    private final NoteRepository noteRepository;

    //쪽지 쓰기
    @PostMapping("/send")
    public ResponseEntity<?> sendNote(@RequestBody NoteSendRequest noteSendRequest){
        ResponseTemplate<?> body;
        try{
            noteService.send(noteSendRequest);
            body = ResponseTemplate.builder()
                    .result(true)
                    .msg("쪽지 전송 완료")
                    .build();
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        catch(Exception e){
            body = ResponseTemplate.builder()
                    .result(false)
                    .msg("send error")
                    .build();
            return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
        }

    }


    //쪽지 삭제

    @DeleteMapping("/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable("noteId") int noteId) throws Exception {
        System.out.println(noteId);
        ResponseTemplate<?> body;
        try{
            noteService.deleteNote(noteId);
            body = ResponseTemplate.builder()
                    .result(true)
                    .msg("쪽지 삭제 완료")
                    .build();
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        catch(Exception e){
            body = ResponseTemplate.builder()
                    .result(false)
                    .msg("쪽지 삭제 error")
                    .build();
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

        }

    }



}
