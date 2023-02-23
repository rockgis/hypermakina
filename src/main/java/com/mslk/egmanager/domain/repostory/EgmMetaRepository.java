package com.mslk.egmanager.domain.repostory;

import com.mslk.egmanager.domain.entity.EgmMetaEntity;
import com.mslk.hypermakina.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EgmMetaRepository extends JpaRepository<EgmMetaEntity, Long> {

    List<EgmMetaEntity> findByMetaNmContaining(@Param("q") String keyword);

    List<EgmMetaEntity> findByMetaHmContaining(@Param("q") String keyword);

    List<EgmMetaEntity> findByMetaEuContaining(@Param("q") String keyword);

    List<EgmMetaEntity> findByMetaMmContaining(@Param("q") String keyword);

    List<EgmMetaEntity> findByMetaWmContaining(@Param("q") String keyword);








}
