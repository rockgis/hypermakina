package com.mslk.hypermakina.ipusenm.domain.repository;

import com.mslk.hypermakina.ipusenm.domain.entity.Gittf0002Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Gittf0002Repository extends JpaRepository<Gittf0002Entity, Long> {

    List<Gittf0002Entity> findByUsrNmContaining(String keyword);
}
