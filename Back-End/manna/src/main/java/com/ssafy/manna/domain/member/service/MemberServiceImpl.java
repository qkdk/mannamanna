package com.ssafy.manna.domain.member.service;

import com.ssafy.manna.domain.member.domain.Member;
import com.ssafy.manna.domain.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.domain.member.dto.request.MemberUpdateRequest;
import com.ssafy.manna.domain.member.dto.response.MemberInfoResponse;
import com.ssafy.manna.domain.member.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public void signUp(MemberSignUpRequest memberSignUpRequest) throws Exception {

    }

    @Override
    public void update(MemberUpdateRequest memberUpdateRequest, String id) throws Exception {

    }

//    @Override
//    public void update(MemberUpdateRequest memberUpdateRequest, String id) throws Exception {
//
//    }

    @Override
    public void delete(String pwd, String id) {

    }

    @Override
    public MemberInfoResponse getInfo(String id) throws Exception {
        return null;
    }

    @Override
    public Optional<Member> findOne(String insertedUserId) {
        return memberRepository.findById(insertedUserId);
    }
}
