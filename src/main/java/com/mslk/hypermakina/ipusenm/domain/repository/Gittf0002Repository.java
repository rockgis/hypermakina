package com.mslk.hypermakina.ipusenm.domain.repository;

import com.mslk.hypermakina.ipusenm.domain.entity.Gittf0002Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Gittf0002Repository extends JpaRepository<Gittf0002Entity, Long> {

    List<Gittf0002Entity> findByUsrNmContaining(@Param("q") String keyword);
}
