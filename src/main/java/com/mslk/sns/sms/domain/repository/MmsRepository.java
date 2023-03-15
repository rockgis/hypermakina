package com.mslk.sns.sms.domain.repository;

import com.mslk.sns.sms.domain.entity.MmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MmsRepository extends JpaRepository<MmsEntity, Long> {
}
