package com.ssafy.manna.member.controller;

import com.ssafy.manna.member.dto.request.MemberDeleteRequest;
import com.ssafy.manna.member.dto.request.MemberLoginRequest;
import com.ssafy.manna.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.member.dto.request.MemberUpdateRequest;
import com.ssafy.manna.member.service.MemberService;
import lombok.RequiredArgsConstructor;
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

@RestController
@RequiredArgsConstructor
@EnableWebMvc
public class MemberController {
    private final MemberService memberService;

    //회원가입
    @PostMapping("/user/regist")
    public ResponseEntity<String> join(@RequestBody MemberSignUpRequest memberSignUpRequest) {
        try {
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
    public void delete(@RequestBody MemberDeleteRequest memberDeleteRequest){
        memberService.delete(memberDeleteRequest.getId(), memberDeleteRequest.getPwd());
    }

    //마이페이지 조회
    @GetMapping("/user/mypage/{id}")
    public void myPage(@Validated  @PathVariable("id")){

    }

    //마이페이지 정보수정
    @PutMapping("/user/mypage")
    public void myPageEdit(MemberUpdateRequest memberUpdateRequest){

    }

    //아이디 찾기
    @GetMapping("/user/findId")
    public void findId(){

    }

    //비밀번호 찾기
    @GetMapping("/user/findPwd")
    public void findPwd(){

    }

}
