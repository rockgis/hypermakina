package com.mslk.hypermakina.member.domain.repository;

import com.mslk.hypermakina.member.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByEmail(String userEmail);
    Optional<MemberEntity> findByRole(String userEmail);
}
