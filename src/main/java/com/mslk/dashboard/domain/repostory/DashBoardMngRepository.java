package com.mslk.dashboard.domain.repostory;

import com.mslk.dashboard.domain.entity.DashBoardMngEntity;
import com.mslk.sns.department.domain.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DashBoardMngRepository extends JpaRepository<DashBoardMngEntity, Long> {

    List<DashBoardMngEntity> findByDsbNmContaining(@Param("q") String keyword);

    List<DashBoardMngEntity> findByDsbEuContaining(@Param("q") String keyword);

    List<DashBoardMngEntity> findByDsbWmContaining(@Param("q") String keyword);


}
