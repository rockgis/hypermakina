package com.mslk.egmanager.domain.repostory;

import com.mslk.egmanager.domain.entity.EgmMetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EgmMetaRepository extends JpaRepository<EgmMetaEntity, Long> {

}
