package com.mslk.hypermakina.board.domain.repository;

import com.mslk.hypermakina.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    List<BoardEntity> findByTitleContaining(String keyword);
}
