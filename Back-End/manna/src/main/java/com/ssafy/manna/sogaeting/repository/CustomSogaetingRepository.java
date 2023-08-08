package com.ssafy.manna.sogaeting.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.ssafy.manna.member.domain.QMember.member;
import static com.ssafy.manna.member.domain.QMemberDetail.*;
import static com.ssafy.manna.member.domain.QProfilePicture.*;
import static org.springframework.util.StringUtils.*;


import com.ssafy.manna.member.domain.QProfilePicture;
import com.ssafy.manna.sogaeting.dto.QSogaetingPictureDto;
import com.ssafy.manna.sogaeting.dto.SogaetingPictureDto;
import com.ssafy.manna.sogaeting.dto.response.QSogeatingPeopleResponse;
import com.ssafy.manna.sogaeting.dto.response.SogeatingPeopleResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomSogaetingRepository {

    private final JPAQueryFactory jpaQueryFactory;

    // 전부 가져오는 기능 - 성별만 다르게
    public List<SogeatingPeopleResponse> sample(String gender, Boolean isSmoker, Boolean isDrinker,
        String mbti) {
//        return jpaQueryFactory
//            .select(new QSogeatingPeopleResponse(
//                member.id,
//                member.name,
//                memberDetail.birth,
//                memberDetail.address.sido,
//                memberDetail.mbti,
//                memberDetail.religion,
//                memberDetail.introduction,
//                memberDetail.isSmoker,
//                memberDetail.isDrinker,
//            ))
//            .from(member)
//            .leftJoin(member.memberDetail, memberDetail)
//            .leftJoin(member.profilePictures, profilePicture).fetchJoin()
//            .where(
//                genderNe(gender),
//                smokerTrue(isSmoker),
//                drinkerTrue(isDrinker),
//                mbtiEq(mbti)
//            )
//            .groupBy(member.id)
//            .fetch();

        return jpaQueryFactory.selectFrom(member).leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(genderNe(gender), smokerTrue(isSmoker), drinkerTrue(isDrinker), mbtiEq(mbti))
            .transform(groupBy(member.id).list(
                Projections.constructor(SogeatingPeopleResponse.class, member.id, member.name,
                    memberDetail.birth, memberDetail.address.sido, memberDetail.mbti,
                    memberDetail.religion, memberDetail.introduction, memberDetail.isSmoker,
                    memberDetail.isDrinker, list(
                        Projections.constructor(SogaetingPictureDto.class, profilePicture.path)))));
    }

    private BooleanExpression genderNe(String gender) {
        return hasText(gender) ? member.gender.ne(gender) : null;
    }

    private BooleanExpression smokerTrue(Boolean isSmoker) {
        if (isSmoker != null) {
            if (isSmoker) {
                return memberDetail.isSmoker.isTrue();
            } else {
                return memberDetail.isSmoker.isFalse();
            }
        }
        return null;
    }

    private BooleanExpression drinkerTrue(Boolean isDrinker) {
        if (isDrinker != null) {
            if (isDrinker) {
                return memberDetail.isSmoker.isTrue();
            } else {
                return memberDetail.isSmoker.isFalse();
            }
        }
        return null;
    }

    private BooleanExpression mbtiEq(String mbti) {
        return hasText(mbti) ? member.gender.eq(mbti) : null;
    }
}
