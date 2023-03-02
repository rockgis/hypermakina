package com.mslk.sns.rank.domain.repository;

import com.mslk.sns.position.domain.entity.PositionEntity;
import com.mslk.sns.rank.domain.entity.RankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankRepository extends JpaRepository<RankEntity, Long> {

    List<RankEntity> findByUidContaining(@Param("q") String keyword);

    List<RankEntity> findByNameContaining(@Param("q") String keyword);


}
