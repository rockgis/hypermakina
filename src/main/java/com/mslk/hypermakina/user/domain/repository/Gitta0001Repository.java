package com.mslk.hypermakina.user.domain.repository;

import com.mslk.hypermakina.user.domain.entity.Gitta0001Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Gitta0001Repository extends JpaRepository<Gitta0001Entity, Long> {

     //String dcd; // '   DCD         VARCHAR(50) COMMENT '부서명',',
     List<Gitta0001Entity>  findByDcdContaining(@Param("q") String dce);

     //String usrNm; // ' USR_NM      VARCHAR(30) COMMENT '사용자명',',
     List<Gitta0001Entity> findByUsrNmContaining(@Param("q") String usrNm);

     //String usrEn ;//'   USR_EN      VARCHAR(30) COMMENT '사번',',
     List<Gitta0001Entity> findByUsrEnContaining(@Param("q") String UsrEn);


    // String emNm; // '    EM_NM       CHAR(20) COMMENT '이메일',',
    List<Gitta0001Entity> findByEmNmContaining(@Param("q") String emNm);


    //String nrIpAr; //'NR_IP_AR    VARCHAR(50) COMMENT '관리공간_IP','

    List<Gitta0001Entity> findByNrIpArContaining(String nrIpAr);


    // String adTf ;//'AD_TF        CHAR(1) COMMENT '관리자여부',',


   //  String earEhf; // ' // '  EAR_EHF    CHAR(1)COMMENT '공용계정 USE_YN',',',
   List<Gitta0001Entity> findByEarEhfContaining(String earEhf);

}
