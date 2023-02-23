package com.mslk.hypermakina.permissionmng.domain.repository;

import com.mslk.hypermakina.permissionmng.domain.entity.Gittc0001Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Gittc0001Repository extends JpaRepository<Gittc0001Entity, Long> {

    List<Gittc0001Entity> findByAppNmContaining(@Param("q") String appNm);
    List<Gittc0001Entity> findByUsrEn(@Param("q") String usrEn);
}
