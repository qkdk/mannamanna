package com.ssafy.manna.schedule.service;

import com.ssafy.manna.schedule.dto.request.OfflineScheduleRequest;
import com.ssafy.manna.schedule.dto.request.OnlineScheduleRequest;
import org.springframework.stereotype.Service;

@Service
public interface OfflineScheduleService {


    //스케줄 등록
    void insertSchedule(OfflineScheduleRequest scheduleRequest) throws Exception;

//    //스케줄 삭제
//    void deleteSchedule(Integer id) throws Exception;

}
