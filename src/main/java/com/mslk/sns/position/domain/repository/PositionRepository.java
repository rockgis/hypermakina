package com.mslk.sns.position.domain.repository;

import com.mslk.sns.position.domain.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {


}
