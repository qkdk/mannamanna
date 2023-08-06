package com.ssafy.manna.messenger.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.messenger.domain.Note;
import com.ssafy.manna.messenger.dto.request.NoteSendRequest;
import com.ssafy.manna.messenger.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NoteServiceImpl implements NoteService{
    private final MemberRepository memberRepository;
    private final NoteRepository noteRepository;
    @Override
    public void send(NoteSendRequest noteSendRequest) throws Exception {

        //받는이
        String receiverId = noteSendRequest.getReceiver();
        Member receiverMember = memberRepository.findById(receiverId).orElseThrow(
                ()-> new Exception("받는 회원 정보가 없습니다.")
        );

        //보낸이
        String senderId = noteSendRequest.getSender();
        Member senderMember = memberRepository.findById(senderId).orElseThrow(
                ()->new Exception("보내는 회원 정보가 없습니다.")
        );

        //현재시간
        LocalDateTime currentDateTime = LocalDateTime.now();
        Note note = Note.builder()
                .receiver(receiverMember)
                .sender(senderMember)
                .subject(noteSendRequest.getSubject())
                .content(noteSendRequest.getContent())
                .date(currentDateTime)
                .isSogae(noteSendRequest.isSogae())
                .isCheck(false)         //읽음 false 로 설정
                .isReject(false)       // 거절 여부 false로 설정
                .build();
        noteRepository.save(note);

    }
}
