package com.ssafy.manna.member.repository;

import com.ssafy.manna.member.domain.ProfilePicture;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture,Integer> {
    Optional<ProfilePicture> findById(Integer id);
}
