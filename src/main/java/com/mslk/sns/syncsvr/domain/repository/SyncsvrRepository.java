package com.mslk.sns.syncsvr.domain.repository;

import com.mslk.sns.rank.domain.entity.RankEntity;
import com.mslk.sns.syncsvr.domain.entity.SyncsvrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SyncsvrRepository extends JpaRepository<SyncsvrEntity, Long> {

    List<SyncsvrEntity> findByUidContaining(@Param("q") String keyword);

    List<SyncsvrEntity> findByNameContaining(@Param("q") String keyword);

    List<SyncsvrEntity> findByIpContaining(@Param("q") String keyword);


}
