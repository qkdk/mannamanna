package com.ssafy.manna.sogaeting.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SogaetingMemberResponsePage {

    int curPage;
    int totalPage;
    List<ImageMappedSogaetingMemberResponse> sogaetingMembers;
}
