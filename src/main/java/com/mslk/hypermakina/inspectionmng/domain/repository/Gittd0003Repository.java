package com.mslk.hypermakina.inspectionmng.domain.repository;

import com.mslk.hypermakina.inspectionmng.domain.entity.Gittd0003Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Gittd0003Repository extends JpaRepository<Gittd0003Entity, Long> {

    List<Gittd0003Entity> findByUsrEnContaining(@Param("q") String appNm);
}
