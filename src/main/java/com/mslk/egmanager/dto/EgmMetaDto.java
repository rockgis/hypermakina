package com.mslk.egmanager.dto;

import com.mslk.egmanager.domain.entity.EgmMetaEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EgmMetaDto {

    private Long id;
    private String metaType; //COMMENT 'META TYPE 정보'
    private String metaNm; //COMMENT 'META 이름',
    private String metaEu; //COMMENT 'META 용도',
    private String metaMm; //COMMENT 'META 모델명',
    private String metaGm; //COMMENT 'META Group',
    private String metaWm; //COMMENT 'META Host 업무명',
    private String metaHm; //COMMENT 'META Host 이름',
    private String metaOs; //COMMENT 'META Host OS',
    private String metaIp; //COMMENT 'META Host IP',

    private String metaCore; // varchar(10) DEFAULT NULL COMMENT 'CPU Core 수',
    private String metaMem; // varchar(10) DEFAULT NULL COMMENT '설치된 메모리 GB',
    private String metaCpucheck; // varchar(10) DEFAULT NULL COMMENT 'CPU 알람',
    private String metaMemcheck;// varchar(10) DEFAULT NULL COMMENT '메모 알람',
    private String metaDiskcheck; // varchar(10) DEFAULT NULL COMMENT '용량 알람',

    private String metaTm; //COMMENT 'META Host 구분',
    private String metaNote; //COMMENT 'META Host 비고',
    private String altEn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    @Builder
    public EgmMetaDto(Long id, String metaType, String metaNm, String metaEu, String metaMm, String metaGm, String metaWm, String metaHm, String metaOs, String metaIp, String metaCore, String metaMem, String metaCpucheck, String metaMemcheck, String metaDiskcheck, String metaTm, String metaNote, String altEn, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.metaType = metaType;
        this.metaNm = metaNm;
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
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public EgmMetaEntity toEntity() {

        EgmMetaEntity egmMetaEntity = EgmMetaEntity.builder()
                .id(id)
                .metaType(metaType)
                .metaNm(metaNm)
                .metaEu(metaEu)
                .metaMm(metaMm)
                .metaGm(metaGm)
                .metaWm(metaWm)
                .metaHm(metaHm)
                .metaOs(metaOs)
                .metaIp(metaIp)
                .metaCore(metaCore)
                .metaMem(metaMem)
                .metaCpucheck(metaCpucheck)
                .metaMemcheck(metaMemcheck)
                .metaDiskcheck(metaDiskcheck)
                .metaTm(metaTm)
                .metaNote(metaNote)
                .altEn(altEn)
                .build();

        return egmMetaEntity;
    }


}
