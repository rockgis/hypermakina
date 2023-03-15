package com.mslk.restapi.domain.repostory;

import com.mslk.restapi.domain.entity.HyperRestApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HyperrestapiRepository extends JpaRepository<HyperRestApiEntity, Long> {

    Optional<HyperRestApiEntity> findByRestFunction(@Param("q") String restFunction);
}
