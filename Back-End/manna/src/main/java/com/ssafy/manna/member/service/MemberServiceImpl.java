package com.ssafy.manna.member.service;

import com.ssafy.manna.global.common.dto.MailDto;
import com.ssafy.manna.member.domain.Member;
import com.ssafy.manna.member.domain.MemberDetail;
import com.ssafy.manna.member.dto.request.MemberFindIdRequest;
import com.ssafy.manna.member.dto.request.MemberFindPwdRequest;
import com.ssafy.manna.member.dto.request.MemberSignUpRequest;
import com.ssafy.manna.member.dto.request.MemberUpdateRequest;
import com.ssafy.manna.member.dto.response.MemberInfoResponse;
import com.ssafy.manna.member.dto.response.MemberLoginResponse;
import com.ssafy.manna.member.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;
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
    public Optional<Member> findMemberByIdAndEmail(MemberFindPwdRequest memberFindPwdRequest) {
        return memberRepository.findById(memberFindPwdRequest.getId());
    }

//    @Override
//    public MemberFindPwdResponse (MemberFindIdOrPwdRequest memberFindPwdRequest) {
//        return null;
//    }

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

    @Override
    public String updatePwd(String findId) {
        Optional<Member> findMember = memberRepository.findById(findId);
        if(findMember.isPresent()){
            // 임시 비밀번호 생성
            Member member= findMember.get();
            String encodedPassword = this.createTempPwd();
            member.updatePassword(encodedPassword);

            memberRepository.save(member);

            return encodedPassword;
        }
        else{
            throw new RuntimeException("Member not found");
        }
    }

    @Override
    public String createTempPwd() {
        char[] charSet = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        String str = "";

        //문자 배열 길이의 값을 랜덤으로 10개 뽑아 구문 작성
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length*Math.random());
            str+=charSet[idx];
        }
        return str;
    }

    @Override
    public MailDto createMail(String memberEmail, String memberEmailDomain, String tempPwd) {
        MailDto dto = new MailDto();
        String email = memberEmail.concat("@"+memberEmailDomain);
        dto.setAddress(email);
        dto.setTitle("맞나만나 임시비밀번호 안내 이메일 입니다.");
        dto.setMessage("안녕하세요. 맞나만나 임시비밀번호 안내 관련 이메일입니다."+" 회원님의 임시 비밀번호는 "+tempPwd+ "입니다."
        +"로그인 후에 비밀번호를 변경해주세요.");
        return dto;
    }


    @Override
    public void sendMail(MailDto mailDto) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());
        message.setFrom(sender);
        javaMailSender.send(message);
    }
}
