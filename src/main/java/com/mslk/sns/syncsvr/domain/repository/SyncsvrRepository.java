package com.mslk.sns.syncsvr.domain.repository;

import com.mslk.sns.syncsvr.domain.entity.SyncsvrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyncsvrRepository extends JpaRepository<SyncsvrEntity, Long> {


}
