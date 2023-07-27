package com.ssafy.manna.member.service;

import com.ssafy.manna.global.common.dto.AddressDto;
import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.domain.MemberAddress;
import com.ssafy.manna.member.dto.request.MemberFindIdRequest;
import com.ssafy.manna.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.member.dto.request.MemberUpdateRequest;
import com.ssafy.manna.member.dto.response.MemberFindIdResponse;
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
//        //id 중복 확인
//        String id = memberSignUpRequest.getId();
//        if(memberRepository.existsById(id)){
//            //있으면
//            throw new RuntimeException("이미 존재하는 id입니다.");
//        }
//
//        //DTO를 entity로 변환
//
//        MemberAddress memberAddress = MemberAddress.builder();
//        MemberDetail memberDetail = MemberDetail.builder()
//                .birth()
//                .height()
//                .emailId()
//                .emailDomain()
//                .job()
//                .isBlockingFriend()
//                .memberAddress()
//                .introduction()
//                .isDrinker()
//                .isSmoker()
//                .mbti()
//                .mileage()
//                .religion()
//                .tel()
//                ;
//
//
//        Member member = Member.builder()
//                        .id(memberSignUpRequest.getId())
//                                .pwd(memberSignUpRequest.getPwd())
//                                        .name(memberSignUpRequest.getName())
//
//        memberRepository.save(member);
//        memberRepository.save(memberSignUpRequest);
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

    @Override
    public MemberFindIdResponse findId(MemberFindIdRequest memberFindIdRequest) {
        //아이디 찾기 - 이름, 생년월일로
        String name = memberFindIdRequest.getName();
        String birth = memberFindIdRequest.getBirth();

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
