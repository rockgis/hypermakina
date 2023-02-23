package com.mslk.hypermakina.user.domain.repository;

import com.mslk.hypermakina.user.domain.entity.Gitta0002Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Gitta0002Repository extends JpaRepository<Gitta0002Entity, Long> {

    List<Gitta0002Entity> findByUsrEnContaining(@Param("q") String keyword);
}
