package com.fastcampus.kaisthackathon.repository;

import com.fastcampus.kaisthackathon.entity.IdolDetailEntity;
import com.fastcampus.kaisthackathon.entity.UserVoteCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdolRepository extends JpaRepository<IdolDetailEntity, Long> {
    Optional<IdolDetailEntity> findByIdolName(String idolName);
}
