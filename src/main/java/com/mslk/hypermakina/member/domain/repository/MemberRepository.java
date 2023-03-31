package com.mslk.hypermakina.member.domain.repository;

import com.mslk.hypermakina.member.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByUid(@Param("q") String uid);
    Optional<MemberEntity> findByRole(@Param("q") String uid);
}
