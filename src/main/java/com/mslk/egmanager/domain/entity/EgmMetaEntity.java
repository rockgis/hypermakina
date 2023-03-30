package com.mslk.egmanager.domain.entity;

import com.mslk.common.domain.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "egmmeta")
public class EgmMetaEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String metaType; //COMMENT 'META TYPE 정보'

    @Column(length = 50, nullable = false)
    private String metaNm; //COMMENT 'META 이름',

    @Column(length = 30, nullable = false)
    private String metaEu; //COMMENT 'META 용도',

    @Column(length = 30, nullable = false)
    private String metaMm; //COMMENT 'META 모델명',

    @Column(length = 30, nullable = false)
    private String metaGm; //COMMENT 'META Group',

    @Column(length = 30, nullable = false)
    private String metaWm; //COMMENT 'META Host 업무명',

    @Column(length = 30, nullable = false)
    private String metaHm; //COMMENT 'META Host 이름',

    @Column(length = 30, nullable = false)
    private String metaOs; //COMMENT 'META Host OS',

    @Column(length = 30, nullable = false)
    private String metaIp; //COMMENT 'META Host IP',


    @Column(length = 10, nullable = false)
    private String metaCore; // varchar(10) DEFAULT NULL COMMENT 'CPU Core 수',
    @Column(length = 10, nullable = false)
    private String metaMem; // varchar(10) DEFAULT NULL COMMENT '설치된 메모리 GB',
    @Column(length = 10, nullable = false)
    private String metaCpucheck; // varchar(10) DEFAULT NULL COMMENT 'CPU 알람',
    @Column(length = 10, nullable = false)
    private String metaMemcheck;// varchar(10) DEFAULT NULL COMMENT '메모 알람',
    @Column(length = 10, nullable = false)
    private String metaDiskcheck; // varchar(10) DEFAULT NULL COMMENT '용량 알람',

    @Column(length = 30, nullable = false)
    private String metaTm; //COMMENT 'META Host 구분',

    @Column(length = 30, nullable = false)
    private String metaNote; //COMMENT 'META Host 비고',


    @Column(length = 30, nullable = false)
    private String altEn;


    @Builder
    public EgmMetaEntity(Long id , String metaType, String metaNm, String metaEu, String metaMm, String metaGm, String metaWm, String metaHm, String metaOs, String metaIp, String metaCore, String metaMem, String metaCpucheck, String metaMemcheck, String metaDiskcheck ,String metaTm, String metaNote, String altEn){
        this.id = id;
        this.metaType = metaType;
        this.metaNm =metaNm;
        this.metaEu = metaEu;
        this.metaMm = metaMm;
        this.metaGm = metaGm;
        this.metaWm = metaWm;
        this.metaHm = metaHm;
        this.metaOs = metaOs;
        this.metaIp = metaIp;
        this.metaCore = metaCore;
        this.metaMem = metaMem;
        this.metaCpucheck = metaCpucheck;
        this.metaMemcheck = metaMemcheck;
        this.metaDiskcheck = metaDiskcheck;
        this.metaTm = metaTm;
        this.metaNote = metaNote;
        this.altEn = altEn;

    }

}
