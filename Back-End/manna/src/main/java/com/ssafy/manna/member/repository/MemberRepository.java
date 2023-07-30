package com.ssafy.manna.member.repository;

import com.ssafy.manna.member.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {

    Optional<Member> findById(String id);   //id로 조회

    //중복 id 조회
    boolean existsById(String id);

    //이름, email id, email domain 으로 조회
    //
    Optional<Member> findByNameAndMemberDetailEmailIdAndMemberDetailEmailDomain(
            String name, String emailId, String emailDomain
    );

//    Optional<Member> findByRefreshToken(String refreshToken);
}