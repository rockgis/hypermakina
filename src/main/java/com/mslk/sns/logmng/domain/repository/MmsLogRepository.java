package com.mslk.sns.logmng.domain.repository;

import com.mslk.sns.logmng.domain.entity.MmsLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MmsLogRepository extends JpaRepository<MmsLogEntity, Long> {

    List<MmsLogEntity> findByMmsTelContaining(@Param("q") String keyword);
}
