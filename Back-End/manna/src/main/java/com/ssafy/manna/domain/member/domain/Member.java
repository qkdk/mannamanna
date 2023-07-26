package com.ssafy.manna.domain.member.domain;

import com.ssafy.manna.global.common.domain.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private String id;
    private String pwd;
    private String name;
    private String gender;
    private Role role;


}
