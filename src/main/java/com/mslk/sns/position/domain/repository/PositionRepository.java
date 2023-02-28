package com.mslk.sns.position.domain.repository;

import com.mslk.sns.department.domain.entity.DepartmentEntity;
import com.mslk.sns.position.domain.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {

    List<PositionEntity> findByUidContaining(@Param("q") String keyword);

    List<PositionEntity> findByNameContaining(@Param("q") String keyword);


}
