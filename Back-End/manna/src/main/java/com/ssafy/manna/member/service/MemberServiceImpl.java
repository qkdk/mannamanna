package com.ssafy.manna.member.service;

import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.domain.MemberDetail;
import com.ssafy.manna.member.dto.request.MemberFindIdRequest;
import com.ssafy.manna.member.dto.request.MemberFindPwdRequest;
import com.ssafy.manna.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.member.dto.request.MemberUpdateRequest;
import com.ssafy.manna.member.dto.response.MemberFindPwdResponse;
import com.ssafy.manna.member.dto.response.MemberInfoResponse;
import com.ssafy.manna.member.dto.response.MemberLoginResponse;
import com.ssafy.manna.member.repository.MemberRepository;
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
//

//        memberRepository.save(member);

//        memberRepository.save(memberSignUpRequest);
    }

    @Override
    public void update(MemberUpdateRequest memberUpdateRequest, String id) throws Exception {

        //해당 id를 가진 member를 찾아서 return
        Member member = memberRepository.findById(id).orElseThrow(()->new RuntimeException("Member not found"));

        MemberDetail memberDetail = member.getMemberDetail();


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

    @Override
    public Optional<Member> findMemberByNameAndEmail(MemberFindIdRequest memberFindIdRequest) {
        //아이디 찾기 - 이름, emailId, emailDomain 으로 찾기
        String name = memberFindIdRequest.getName();
        String emailId = memberFindIdRequest.getEmailId();
        String emailDomain = memberFindIdRequest.getEmailDomain();


        return memberRepository.findByNameAndMemberDetailEmailIdAndMemberDetailEmailDomain(name,emailId,emailDomain);

    }

    @Override
    public MemberFindPwdResponse findPwd(MemberFindPwdRequest memberFindPwdRequest) {
        return null;
    }

    @Override
    public MemberInfoResponse convertToMemberInfoDto(Member member) {
        return null;
    }

    @Override
    public MemberLoginResponse converToMemberLoginDto(Member member) {
        return null;
    }

    @Override
    public MemberInfoResponse convertToDto(Member member) {
        //반환할 dto
//        MemberInfoResponse memberInfoResponse = new MemberInfoResponse();
//
//        memberInfoResponse.setName(member.getName());
//
//        //MemberAddress : Entity
//        MemberAddress memberAddress = member.getMemberDetail().getMemberAddress();
//
//        //MemberAddress->AddressDto 로 변환
//        AddressDto addressDto = new AddressDto();
//        addressDto.setDetail(memberAddress.getDetail());
//        addressDto.setLatitude(memberAddress.getLatitude());
//        addressDto.setLongitude(memberAddress.getLongitude());
//        addressDto.setSidoId(memberAddress.getSido().getId());
//        addressDto.setGugunId(memberAddress.getGugun().getId());
//
//        memberInfoResponse.setAddress(addressDto);
//
//        return memberInfoResponse;
        return null;
    }
}
