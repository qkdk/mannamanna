package com.ssafy.manna.domain.member.repository;

import com.ssafy.manna.domain.member.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {

    Optional<Member> findById(String id);   //id로 조회

    //중복 id 조회
    boolean existsById(String id);

//    Optional<Member> findByRefreshToken(String refreshToken);
}