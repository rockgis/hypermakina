package com.mslk.sns.staff.domain.repository;

import com.mslk.sns.staff.domain.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepository extends JpaRepository<StaffEntity, Long> {

    // uid   아이디
    List<StaffEntity> findByUidContaining(@Param("q") String keyword);
    // fullName 이름
    List<StaffEntity> findByFullNameContaining(@Param("q") String keyword);

    // identityNo  사원번호
    List<StaffEntity> findByIdentityNoContaining(@Param("q") String keyword);

    // eMail 이메일
    List<StaffEntity> findByeMailContaining(@Param("q") String keyword);

    // hp 헨드폰 번호
    List<StaffEntity> findByHpContaining(@Param("q") String keyword);


    @Query("select count(p.uid) from StaffEntity p where p.uid = :uid")
    int findUidCount(@Param("uid") String uid);


    @Query("select count(p.uid) from StaffEntity p where p.identityNo = :identityNo")
    int findIdentityNoCount(@Param("identityNo") String identityNo);

    @Query("select count(p.uid) from StaffEntity p where p.eMail = :eMail")
    int findeMailCount(@Param("eMail") String eMail);

    @Query("select p.id from StaffEntity p where p.uid = :uid and p.pw = :pw")
    Long findeUserNo(@Param("uid") String uid, @Param("pw") String pw);





}
