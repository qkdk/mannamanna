package com.ssafy.manna.member.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.dto.request.MemberFindIdRequest;
import com.ssafy.manna.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.member.dto.request.MemberUpdateRequest;
import com.ssafy.manna.member.dto.response.MemberFindIdResponse;
import com.ssafy.manna.member.dto.response.MemberInfoResponse;
import com.ssafy.manna.member.dto.response.MemberLoginResponse;
import java.util.Optional;


public interface MemberService {
    //회원가입
    void signUp(MemberSignUpRequest memberSignUpRequest) throws Exception;

    //정보 수정
    void update(MemberUpdateRequest memberUpdateRequest, String id) throws Exception;

    //회원탈퇴
    void delete(String pwd, String id);

    //정보조회
    MemberInfoResponse getInfo(String id) throws Exception;

    Optional<Member> findOne(String insertedUserId);

    //Id로 회원 찾기


//    void signUp(String id, String pwd);

    //ID찾기
    MemberFindIdResponse findId(MemberFindIdRequest memberFindIdRequest);
    //converToDto
    MemberInfoResponse convertToMemberInfoDto(Member member);
    MemberLoginResponse converToMemberLoginDto(Member member);

    MemberInfoResponse convertToDto(Member member);
}