package com.mslk.egmanager.domain.repostory;

import com.mslk.egmanager.domain.entity.EgmDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EgmDataRepository extends JpaRepository<EgmDataEntity, Long> {

}
