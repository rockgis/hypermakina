package com.mslk.hypermakina.code.domain.repostory;

import com.mslk.hypermakina.code.domain.entity.CodeMngEntity;
import com.mslk.sns.department.domain.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeMngRepository extends JpaRepository<CodeMngEntity, Long> {

    List<CodeMngEntity> findByCodeTypeAndCodeGmNot(@Param("codeType") String codeType, @Param("codeGm") String codeGm);

}
