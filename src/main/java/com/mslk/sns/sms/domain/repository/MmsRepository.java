package com.mslk.sns.sms.domain.repository;

import com.mslk.sns.sms.domain.entity.LguMmsEntity;
import com.mslk.sns.sms.domain.entity.MmsEntity;
import com.mslk.sns.staff.domain.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MmsRepository extends JpaRepository<MmsEntity, Long> {

    Optional<MmsEntity> findByType(@Param("q") String type);

}
