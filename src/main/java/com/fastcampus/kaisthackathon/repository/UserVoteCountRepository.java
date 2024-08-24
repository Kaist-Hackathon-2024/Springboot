package com.fastcampus.kaisthackathon.repository;

import com.fastcampus.kaisthackathon.entity.UserVoteCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserVoteCountRepository extends JpaRepository<UserVoteCountEntity, Long> {
    Optional<UserVoteCountEntity> findByUserId(Long userId);
}
