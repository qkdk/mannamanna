package com.ssafy.manna.sogaeting.repository;

import static com.ssafy.manna.member.domain.QMember.member;
import static com.ssafy.manna.member.domain.QMemberDetail.memberDetail;
import static com.ssafy.manna.member.domain.QProfilePicture.profilePicture;
import static org.springframework.util.StringUtils.hasText;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.manna.sogaeting.dto.response.QSogaetingMemberResponse;
import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomSogaetingRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<SogaetingMemberResponse> findMemberByConditionAndOnlineState(
        List<String> onLineMembersId,
        String gender, Boolean isSmoker, Boolean isDrinker, String mbti, String sido, Integer offset) {
        return jpaQueryFactory
            .select(new QSogaetingMemberResponse(
                member.id,
                member.name,
                memberDetail.birth,
                memberDetail.address.sido,
                memberDetail.mbti,
                memberDetail.religion,
                memberDetail.introduction,
                memberDetail.isSmoker,
                memberDetail.isDrinker,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(gender),
                smokerTrue(isSmoker),
                drinkerTrue(isDrinker),
                mbtiEq(mbti),
                sidoEq(sido),
                profilePicture.priority.eq(1),
                member.id.in(onLineMembersId)
            )
            .offset(offset * 6)
            .limit(6)
            .fetch();
    }

    public List<SogaetingMemberResponse> findMemberByCondition(String gender, Boolean isSmoker,
        Boolean isDrinker, String mbti, String sido, Integer offset) {
        return jpaQueryFactory
            .select(new QSogaetingMemberResponse(
                member.id,
                member.name,
                memberDetail.birth,
                memberDetail.address.sido,
                memberDetail.mbti,
                memberDetail.religion,
                memberDetail.introduction,
                memberDetail.isSmoker,
                memberDetail.isDrinker,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(gender),
                smokerTrue(isSmoker),
                drinkerTrue(isDrinker),
                mbtiEq(mbti),
                sidoEq(sido),
                profilePicture.priority.eq(1))
            .offset(offset * 6)
            .limit(6)
            .fetch();
    }

    private BooleanExpression sidoEq(String sido) {
        return hasText(sido) ? memberDetail.address.sido.eq(sido) : null;
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
