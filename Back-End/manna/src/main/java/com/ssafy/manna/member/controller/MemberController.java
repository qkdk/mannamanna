package com.ssafy.manna.member.controller;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.dto.request.MemberDeleteRequest;
import com.ssafy.manna.member.dto.request.MemberFindIdRequest;
import com.ssafy.manna.member.dto.request.MemberFindPwdRequest;
import com.ssafy.manna.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.member.dto.request.MemberUpdateRequest;
import com.ssafy.manna.member.dto.response.MemberFindIdResponse;
import com.ssafy.manna.member.dto.response.MemberFindPwdResponse;
import com.ssafy.manna.member.dto.response.MemberInfoResponse;
import com.ssafy.manna.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@EnableWebMvc
@Slf4j
public class MemberController {
    private final MemberService memberService;

    //임시 매핑
//    @PostMapping("/here")
//    public void imsi(){
//        log.info("임시 로그");
//    }

    //회원가입
    @PostMapping("/user/regist")
    public ResponseEntity<String> join(@RequestBody MemberSignUpRequest memberSignUpRequest) {
        try {
            log.info("회원가입");
            // 회원가입 시 카카오 인증

            memberService.signUp(memberSignUpRequest);
            return ResponseEntity.ok("join success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //로그인

//    @PostMapping("/user/login")
//    public void login(@RequestBody MemberLoginRequest memberLoginRequest){
//        //로그인
//
//    }

    //회원탈퇴
    @DeleteMapping("/user/delete")
    public ResponseEntity<String> delete(@RequestBody MemberDeleteRequest memberDeleteRequest){
        try{
            memberService.delete(memberDeleteRequest.getId(), memberDeleteRequest.getPwd());
            return ResponseEntity.ok("delete success");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //마이페이지 조회
    @GetMapping("/user/mypage/{id}")
    public ResponseEntity<MemberInfoResponse> myPage(@Validated @PathVariable("id") String id){
        try{
            //id로 member 조회
            MemberInfoResponse memberInfoResponse = memberService.getInfo(id);
            return ResponseEntity.ok(memberInfoResponse);
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    //마이페이지 정보수정
    @PutMapping("/user/mypage/{id}")
    public ResponseEntity<String> myPageEdit(MemberUpdateRequest memberUpdateRequest, @PathVariable("id") String id){
        try{
            memberService.update(memberUpdateRequest,id);
            return ResponseEntity.ok(" 수정 성공");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //아이디 찾기
    @PostMapping("/user/findId")
    public ResponseEntity<MemberFindIdResponse> findId(@RequestBody MemberFindIdRequest memberFindIdRequest){
        Optional<Member> findMember = memberService.findMemberByNameAndEmail(memberFindIdRequest);
        if(findMember.isPresent()){
            String findId = findMember.get().getId();
            MemberFindIdResponse memberFindIdResponse = new MemberFindIdResponse(findId);
            return ResponseEntity.ok(memberFindIdResponse);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //비밀번호 찾기
    @GetMapping("/user/findPwd")
    public ResponseEntity<MemberFindPwdResponse> findPwd(@RequestBody MemberFindPwdRequest memberFindPwdRequest){

        MemberFindPwdResponse findPwdDto = memberService.findPwd(memberFindPwdRequest);
        return null;
    }


}
