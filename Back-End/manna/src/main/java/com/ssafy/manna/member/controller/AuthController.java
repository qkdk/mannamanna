package com.ssafy.manna.member.controller;


import com.ssafy.manna.member.dto.request.MemberLoginRequest;
import com.ssafy.manna.global.util.SecurityUtil;
import com.ssafy.manna.global.util.jwt.JwtFilter;
import com.ssafy.manna.global.util.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authorize(@RequestBody MemberLoginRequest loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(loginDto.getId(), loginDto.getPwd());

        // CustomUserDetailsService의 override 함수가 실행되고
        // 이후에 검사를 실시함
        // 오류가 나타나면 서비스단에서 오류 발생시킴 걱정ㄴㄴ
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);
        String auth = SecurityUtil.getAuthority(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

//        return new ResponseEntity<>(
//                ResponseTemplate.<LoginResponseDto>builder()
//                        .result(true)
//                        .msg("로그인에 성공헸습니다")
//                        .data(new LoginResponseDto(jwt, auth, loginDto.getUserId()))
//                        .build()
//                , httpHeaders, HttpStatus.OK);

        return null;
    }
}
