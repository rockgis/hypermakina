package com.mslk.sns.staff.domain.repository;

import com.mslk.sns.staff.domain.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<StaffEntity, Long> {

    List<StaffEntity> findByeMailContaining(String keyword);

}
