package com.ssafy.manna.schedule.service;

import com.ssafy.manna.schedule.dto.request.OnlineScheduleRequest;
import com.ssafy.manna.schedule.dto.response.OnlineScheduleResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface OnlineScheduleService {

    //스케줄 등록
    void insertSchedule(OnlineScheduleRequest scheduleRequest) throws Exception;

    //스케줄 삭제
    void deleteSchedule(Integer id) throws Exception;

    // 회원 전체 스케줄 return
    List<OnlineScheduleResponse> getAllSchedule(String userId) throws Exception;

}
