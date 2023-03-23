package com.mslk.sns.concurrent.domain.repository;

import com.mslk.sns.concurrent.domain.entity.ConcurrentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConcurrentRepository extends JpaRepository<ConcurrentEntity, Long> {


}
