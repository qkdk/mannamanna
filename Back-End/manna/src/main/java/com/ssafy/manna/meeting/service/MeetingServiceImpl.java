package com.ssafy.manna.meeting.service;

import com.ssafy.manna.meeting.domain.Meeting;
import com.ssafy.manna.meeting.dto.request.MeetingMakeRoomRequest;
import com.ssafy.manna.meeting.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;

    // 미팅 방 만들기
    @Override
    public void MakeRoom(MeetingMakeRoomRequest meetingMakeRoomRequest) throws Exception {
        Meeting meeting = Meeting.builder()
                .name(meetingMakeRoomRequest.getName())
                .host(meetingMakeRoomRequest.getHost())
                .game(meetingMakeRoomRequest.getGame())
                .isOpenProfile(meetingMakeRoomRequest.getIsOpenProfile())
                .level(meetingMakeRoomRequest.getLevel())
                .build();
        meetingRepository.save(meeting);
    }
}
