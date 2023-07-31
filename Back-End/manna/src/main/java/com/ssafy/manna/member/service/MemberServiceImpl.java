package com.ssafy.manna.member.service;

import com.ssafy.manna.global.common.domain.Address;
import com.ssafy.manna.global.common.domain.Gugun;
import com.ssafy.manna.global.common.domain.Sido;
import com.ssafy.manna.global.common.repository.AddressRepository;
import com.ssafy.manna.global.common.repository.GugunRepository;
import com.ssafy.manna.global.common.repository.SidoRepository;
import com.ssafy.manna.member.Enums.UserRole;
import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.domain.MemberDetail;
import com.ssafy.manna.member.dto.request.MemberFindIdRequest;
import com.ssafy.manna.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.member.dto.request.MemberUpdateRequest;
import com.ssafy.manna.member.dto.response.MemberFindIdResponse;
import com.ssafy.manna.member.dto.response.MemberInfoResponse;
import com.ssafy.manna.member.dto.response.MemberLoginResponse;
import com.ssafy.manna.member.repository.MemberDetailRepository;
import com.ssafy.manna.member.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberDetailRepository memberDetailRepository;
    private final AddressRepository AddressRepository;
    private final SidoRepository sidoRepository;
    private final GugunRepository gugunRepository;

    @Override
    public void signUp(MemberSignUpRequest memberSignUpRequest) throws Exception {
        if (memberRepository.findById(memberSignUpRequest.getId()).isPresent()) {
            log.info("이미 있는 회원입니다.");
            throw new Exception("이미 존재하는 이메일입니다.");
        }

        System.out.println("before: sido");
        Sido sido = sidoRepository.findByName(memberSignUpRequest.getSido()).orElseThrow(
            () -> new Exception("일치하는 시도가 없습니다.")
        );

        System.out.println("before: gugun");
        Gugun gugun = gugunRepository.findByNameAndSido(memberSignUpRequest.getGugun(), sido)
            .orElseThrow(
                () -> new Exception("일치하는 구군이 없습니다.")
            );

        System.out.println("before: address");
        Address address = new Address(sido, gugun,
            memberSignUpRequest.getDetail(),
            memberSignUpRequest.getLatitude(), memberSignUpRequest.getLongitude());

        System.out.println("before: member");
        Member member = Member.builder()
            .id(memberSignUpRequest.getId())
            .pwd(memberSignUpRequest.getPwd())
            .gender(memberSignUpRequest.getGender())
            .name(memberSignUpRequest.getName())
            .role(UserRole.ROLE_USER)
            .build();

        MemberDetail memberDetail = MemberDetail.builder()
            .id(member.getId())
            .member(member)
            .address(address)
            .tel(memberSignUpRequest.getTel())
            .birth(memberSignUpRequest.getBirth())
            .emailId(memberSignUpRequest.getEmailId())
            .emailDomain(memberSignUpRequest.getEmailDomain())
            .height(memberSignUpRequest.getHeight())
            .job(memberSignUpRequest.getJob())
            .isSmoker(memberSignUpRequest.isSmoker())
            .isDrinker(memberSignUpRequest.isDrinker())
            .mbti(memberSignUpRequest.getMbti())
            .religion(memberSignUpRequest.getReligion())
            .introduction(memberSignUpRequest.getIntroduction())
            .isBlockingFriend(memberSignUpRequest.isBlockingFriend())
            .mileage(0)
            .build();

        memberDetailRepository.save(memberDetail);
        System.out.println("after: saveMemberDetail");
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
