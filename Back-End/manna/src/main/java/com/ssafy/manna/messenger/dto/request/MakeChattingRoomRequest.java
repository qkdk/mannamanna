package com.ssafy.manna.messenger.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MakeChattingRoomRequest {

    private String maleId;
    private String femaleId;
}
