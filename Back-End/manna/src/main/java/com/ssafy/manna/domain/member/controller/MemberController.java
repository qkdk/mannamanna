package com.ssafy.manna.domain.member.controller;

import com.ssafy.manna.domain.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입
    @PostMapping("/user/regist")
    public ResponseEntity<String> join(@RequestBody MemberSignUpRequest dto) {
        try {
            memberService.signUp(dto);
            return ResponseEntity.ok("join success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //로그인

    @PostMapping("/user/login")
    public void login(){

    }

    //회원탈퇴
    @PostMapping("/user/delete")
    public void delete(){

    }

    //마이페이지 조회
    @GetMapping("/user/mypage/{id}")
    public void myPage(){

    }

    //마이페이지 정보수정
    @PutMapping("/user/mypage")
    public void myPageEdit(){

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
