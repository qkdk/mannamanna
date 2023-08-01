package com.ssafy.manna.meeting.service;

import com.ssafy.manna.meeting.dto.request.MeetingMakeRoomRequest;

public interface MeetingService {

    void MakeRoom(MeetingMakeRoomRequest meetingMakeRoomRequest) throws Exception;
}
