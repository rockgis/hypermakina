package com.mslk.restapi.domain.repostory;

import com.mslk.restapi.domain.entity.HyperRestApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HyperrestapiRepository extends JpaRepository<HyperRestApiEntity, Long> {


}
