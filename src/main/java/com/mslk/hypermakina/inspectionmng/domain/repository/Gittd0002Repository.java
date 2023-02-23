package com.mslk.hypermakina.inspectionmng.domain.repository;

import com.mslk.hypermakina.inspectionmng.domain.entity.Gittd0002Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Gittd0002Repository extends JpaRepository<Gittd0002Entity, Long> {

    List<Gittd0002Entity> findByUsrEnContaining(@Param("q") String appNm);
}
