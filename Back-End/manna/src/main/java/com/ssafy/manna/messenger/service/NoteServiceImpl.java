package com.ssafy.manna.messenger.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.repository.MemberRepository;
import com.ssafy.manna.messenger.domain.Note;
import com.ssafy.manna.messenger.dto.request.NoteSendRequest;
import com.ssafy.manna.messenger.dto.request.SogaeNoteSendRequest;
import com.ssafy.manna.messenger.dto.response.NoteDetailResponse;
import com.ssafy.manna.messenger.dto.response.NoteListResponse;
import com.ssafy.manna.messenger.dto.response.ReceivedNoteResponse;
import com.ssafy.manna.messenger.dto.response.SentNoteResponse;
import com.ssafy.manna.messenger.dto.response.SogaeNoteDetailResponse;
import com.ssafy.manna.messenger.repository.NoteRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.expression.ExpressionException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NoteServiceImpl implements NoteService{
    private final MemberRepository memberRepository;
    private final NoteRepository noteRepository;

    @Value("${file.server-domain}")
    private String SERVER_DOMAIN;
    // 일반 쪽지 쓰기
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
                .isSogae(false)         // 소개팅 쪽지 여부 false 설정
                .isCheck(false)         //읽음 false 로 설정
                .isReject(false)       // 거절 여부 false로 설정
                .build();
        noteRepository.save(note);

    }


    //소개팅 쪽지 전송
    @Override
    public void sendSogaeNote(SogaeNoteSendRequest sogaeNoteSendRequest) throws Exception {
        // 받는이
        Member receiver = memberRepository.findByName(sogaeNoteSendRequest.getReceiver()).orElseThrow(()-> new Exception("회원 정보가 없습니다."));
        // 보내는이
        Member sender = memberRepository.findByName(sogaeNoteSendRequest.getSender()).orElseThrow(()-> new Exception("회원 정보가 없습니다."));
        // 제목
        String subject = sogaeNoteSendRequest.getSender() + "님이 소개팅 신청을 하셨습니다.";
        // 날짜
        LocalDateTime date = sogaeNoteSendRequest.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
        String formattedDateTime = date.format(formatter);
        // 내용
        String content = sogaeNoteSendRequest.getSender()+"님이 "+sogaeNoteSendRequest.getReceiver()+"님께 소개팅 신청을 하셨습니다.\n"
                +"D-Day : " + formattedDateTime;

        //online, offline 여부 나중에 판단

        Note note = Note.builder()
                .receiver(receiver)
                .sender(sender)
                .subject(subject)
                .content(content)
                .date(LocalDateTime.now())
                .isSogae(true)          //소개팅 쪽지 여부 true
                .isCheck(false)         //읽음 false 로 설정
                .isReject(false)       // 거절 여부 false로 설정
                .build();
        noteRepository.save(note);

    }

    //소개팅 쪽지 보내기


    @Override
    public void deleteNote(int id) throws Exception {
        Note deleteNote = noteRepository.findById(id).orElseThrow(()->new Exception("쪽지를 찾을 수 없습니다."));
        noteRepository.delete(deleteNote);
    }


    //일반 쪽지 상세보기
    @Override
    public NoteDetailResponse readDetailNote(int id) throws Exception {

        //쪽지 정보 찾아서
        Note note = noteRepository.findById(id).orElseThrow(()-> new Exception("쪽지를 찾을 수 없습니다."));
        //읽음 처리
        note.updateIsCheck(true);
        //NoteDetailResponse 로 보내기
        NoteDetailResponse noteDetailResponse = new NoteDetailResponse().builder()
                .id(id)
                .sender(note.getSender().getName())
                .receiver(note.getReceiver().getName())
                .subject(note.getSubject())
                .content(note.getContent())
                .isCheck(note.getIsCheck())
                .build();
        return noteDetailResponse;
    }


    //소개팅 쪽지 상세 보기 - 상대방 프로필 표출
    @Override
    public SogaeNoteDetailResponse readSogaeDetailNote(int id) throws Exception {

        //쪽지 정보 찾기
        Note note = noteRepository.findById(id).orElseThrow(()->new ExpressionException("쪽지를 찾을 수 없습니다."));
        //받는이
        //        Member receiver = note.getReceiver();
        //보낸이
        Member sender = note.getSender();

        //상대방 프로필 표출

        SogaeNoteDetailResponse sogaeNoteDetailResponse = new SogaeNoteDetailResponse().builder()
                .name(sender.getName())
                .height(sender.getMemberDetail().getHeight())
                .birth(Integer.parseInt(sender.getMemberDetail().getBirth()))
                .job(sender.getMemberDetail().getJob())
                .mbti(sender.getMemberDetail().getMbti())
                .introduction(sender.getMemberDetail().getIntroduction())
                .imgPath(SERVER_DOMAIN+"/img/"+sender.getProfilePictures().get(0).getName())
                .build();
        return sogaeNoteDetailResponse;
    }

    @Override
    public List<NoteListResponse> receivedNoteList(String userId) throws Exception {
        List<Note> receivedNoteList = noteRepository.findAllByReceiverId(userId);
        List<NoteListResponse> noteListResponses = new ArrayList<>();
        for(Note receivedNote:receivedNoteList){
            NoteListResponse noteListResponse = new NoteListResponse().builder()
                    .id(receivedNote.getId())
                    .receiverId(receivedNote.getReceiver().getId())
                    .receiverName(receivedNote.getReceiver().getName())
                    .senderId(receivedNote.getSender().getId())
                    .senderName(receivedNote.getSender().getName())
                    .subject(receivedNote.getSubject())
                    .content(receivedNote.getContent())
                    .date(receivedNote.getDate())
                    .isSogae(receivedNote.getIsSogae())
                    .isCheck(receivedNote.getIsCheck())
                    .isReject(receivedNote.getIsReject())
                   .build();

            noteListResponses.add(noteListResponse);
        }
        return noteListResponses;
    }

    @Override
    public List<NoteListResponse> sentNoteList(String userId) throws Exception {
        List<Note> sentNoteList = noteRepository.findAllBySenderId(userId);
        List<NoteListResponse> noteListResponses = new ArrayList<>();
        for(Note sentNote:sentNoteList){
            NoteListResponse noteListResponse = new NoteListResponse().builder()
                    .id(sentNote.getId())
                    .receiverId(sentNote.getReceiver().getId())
                    .receiverName(sentNote.getReceiver().getName())
                    .senderId(sentNote.getSender().getId())
                    .senderName(sentNote.getSender().getName())
                    .subject(sentNote.getSubject())
                    .content(sentNote.getContent())
                    .date(sentNote.getDate())
                    .isSogae(sentNote.getIsSogae())
                    .isCheck(sentNote.getIsCheck())
                    .isReject(sentNote.getIsReject())
                    .build();

            noteListResponses.add(noteListResponse);
        }
        return noteListResponses;
    }
}
