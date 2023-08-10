package com.ssafy.manna.sogaeting.repository;

import static com.ssafy.manna.member.domain.QMember.member;
import static com.ssafy.manna.member.domain.QMemberDetail.memberDetail;
import static com.ssafy.manna.member.domain.QProfilePicture.profilePicture;
import static org.springframework.util.StringUtils.hasText;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.manna.sogaeting.dto.request.SogaetingFilteringRequest;
import com.ssafy.manna.sogaeting.dto.response.QSogaetingMemberResponse;
import com.ssafy.manna.sogaeting.dto.response.SogaetingMemberResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomSogaetingRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Page<SogaetingMemberResponse> findMemberByCondition(
        SogaetingFilteringRequest sogaetingFilteringRequest, Pageable pageable) {

        List<SogaetingMemberResponse> content = jpaQueryFactory
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
                memberDetail.height,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(sogaetingFilteringRequest.getGender()),
                smokerTrue(sogaetingFilteringRequest.getIsSmoker()),
                drinkerTrue(sogaetingFilteringRequest.getIsDrinker()),
                mbtiEq(sogaetingFilteringRequest.getMbti()))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        long total = jpaQueryFactory
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
                memberDetail.height,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(sogaetingFilteringRequest.getGender()),
                smokerTrue(sogaetingFilteringRequest.getIsSmoker()),
                drinkerTrue(sogaetingFilteringRequest.getIsDrinker()),
                mbtiEq(sogaetingFilteringRequest.getMbti()))
            .fetchCount();

        return new PageImpl<>(content, pageable, total);
    }


    public Page<SogaetingMemberResponse> findMemberByConditionAndOnlineState(
        List<String> onLineMembersId, Pageable pageable,
        SogaetingFilteringRequest sogaetingFilteringRequest) {

        List<SogaetingMemberResponse> content = jpaQueryFactory
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
                memberDetail.height,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(sogaetingFilteringRequest.getGender()),
                smokerTrue(sogaetingFilteringRequest.getIsSmoker()),
                drinkerTrue(sogaetingFilteringRequest.getIsDrinker()),
                mbtiEq(sogaetingFilteringRequest.getMbti()),
                member.id.in(onLineMembersId)
            )
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        long total = jpaQueryFactory
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
                memberDetail.height,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(sogaetingFilteringRequest.getGender()),
                smokerTrue(sogaetingFilteringRequest.getIsSmoker()),
                drinkerTrue(sogaetingFilteringRequest.getIsDrinker()),
                mbtiEq(sogaetingFilteringRequest.getMbti()),
                member.id.in(onLineMembersId)
            )
            .fetchCount();

        return new PageImpl<>(content, pageable, total);
    }

    public Page<SogaetingMemberResponse> findMemberByConditionAndLocate(Pageable pageable,
        String locate, SogaetingFilteringRequest sogaetingFilteringRequest) {

        List<SogaetingMemberResponse> content = jpaQueryFactory
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
                memberDetail.height,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(sogaetingFilteringRequest.getGender()),
                smokerTrue(sogaetingFilteringRequest.getIsSmoker()),
                drinkerTrue(sogaetingFilteringRequest.getIsDrinker()),
                mbtiEq(sogaetingFilteringRequest.getMbti()),
                sidoEq(locate))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        long total = jpaQueryFactory
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
                memberDetail.height,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(sogaetingFilteringRequest.getGender()),
                smokerTrue(sogaetingFilteringRequest.getIsSmoker()),
                drinkerTrue(sogaetingFilteringRequest.getIsDrinker()),
                mbtiEq(sogaetingFilteringRequest.getMbti()),
                sidoEq(locate))
            .fetchCount();

        return new PageImpl<>(content, pageable, total);
    }

    public Page<SogaetingMemberResponse> findMemberByConditionAndOnlineStateAndLocate(
        List<String> onLineMembersId, Pageable pageable, String sido,
        SogaetingFilteringRequest sogaetingFilteringRequest) {
        List<SogaetingMemberResponse> content = jpaQueryFactory
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
                memberDetail.height,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(sogaetingFilteringRequest.getGender()),
                smokerTrue(sogaetingFilteringRequest.getIsSmoker()),
                drinkerTrue(sogaetingFilteringRequest.getIsDrinker()),
                mbtiEq(sogaetingFilteringRequest.getMbti()),
                sidoEq(sido),
                member.id.in(onLineMembersId)
            )
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        long total = jpaQueryFactory
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
                memberDetail.height,
                profilePicture.path
            ))
            .from(member)
            .leftJoin(member.memberDetail, memberDetail)
            .leftJoin(member.profilePictures, profilePicture)
            .where(
                genderNe(sogaetingFilteringRequest.getGender()),
                smokerTrue(sogaetingFilteringRequest.getIsSmoker()),
                drinkerTrue(sogaetingFilteringRequest.getIsDrinker()),
                mbtiEq(sogaetingFilteringRequest.getMbti()),
                sidoEq(sido),
                member.id.in(onLineMembersId)
            )
            .fetchCount();

        return new PageImpl<>(content, pageable, total);
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
