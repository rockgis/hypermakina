package com.mslk.sns.sms.domain.repository;

import com.mslk.sns.sms.domain.entity.LguMmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MmsRepository extends JpaRepository<LguMmsEntity, Long> {
}
