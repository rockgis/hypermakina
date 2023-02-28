package com.mslk.sns.department.domain.repository;

import com.mslk.sns.department.domain.entity.DepartmentEntity;
import com.mslk.sns.staff.domain.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    List<DepartmentEntity> findByUidContaining(@Param("q") String keyword);

    List<DepartmentEntity> findByNameContaining(@Param("q") String keyword);


}
