package com.ssafy.manna.domain.member.service;

import com.ssafy.manna.domain.member.domain.Member;
import com.ssafy.manna.domain.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.domain.member.dto.response.MemberInfoResponse;
import com.ssafy.manna.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface MemberService {
    //회원가입
    void signUp(MemberSignUpRequest memberSignUpRequest) throws Exception;

    //정보 수정
    void update(MemberUpdateRequest memberUpdateRequest, String id) throws Exception;

    //회원탈퇴
    void delete(String pwd, String id);

    //정보조회
    MemberInfoResponse getInfo(String id) throws Exception;




}