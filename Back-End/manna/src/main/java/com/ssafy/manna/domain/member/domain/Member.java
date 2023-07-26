package com.ssafy.manna.domain.member.domain;

import com.ssafy.manna.global.common.domain.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    private String id;      //사용자 아이디(PK)
    private String pwd;     //사용자 비밀번호
    private String name;    //사용자 이름
    private String gender;  //성별
    @Enumerated(EnumType.STRING)
    private Role role;      //ROLE

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private MemberDetail memberDetail;


}
