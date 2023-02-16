package com.mslk.hypermakina.inspectionmng.domain.repository;

import com.mslk.hypermakina.inspectionmng.domain.entity.Gittd0001Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Gittd0001Repository extends JpaRepository<Gittd0001Entity, Long> {

    List<Gittd0001Entity> findByUgNmContaining(String appNm);
}
