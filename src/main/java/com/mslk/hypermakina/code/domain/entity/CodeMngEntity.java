package com.mslk.hypermakina.code.domain.entity;

import com.mslk.common.domain.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "codemng")
public class CodeMngEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String codeType; // COMMENT 'CODE TYPE',

    @Column(length = 30, nullable = false)
    private String codeEu; // COMMENT 'CODE 용도',

    @Column(length = 30, nullable = false)
    private String codeGm; // COMMENT 'CODE Group',

    @Column(length = 30, nullable = false)
    private String codeWm; // COMMENT 'CODE 업무명',

    @Column(length = 10, nullable = false)
    private String codeNm; //  COMMENT 'CODE 이름',

    @Column(length = 10, nullable = false)
    private String codeVm; //  COMMENT 'CODE 값',

    @Column(length = 200, nullable = false)
    private String codeNote; //   COMMENT 'Code 비고',

    @Column(length = 1, nullable = false)
    private String seTf; //COMMENT '사용유무',

    @Column(length = 30, nullable = false)
    private String altEn;

    @Builder
    public CodeMngEntity(Long id , String codeType, String codeEu, String codeGm, String codeWm, String codeNm, String codeVm,  String codeNote, String seTf, String altEn){
        this.id = id;
        this.codeType = codeType;
        this.codeEu =codeEu;
        this.codeGm = codeGm;
        this.codeWm = codeWm;
        this.codeNm = codeNm;
        this.codeVm = codeVm;
        this.codeNote = codeNote;
        this.seTf = seTf;
        this.altEn = altEn;

    }



}
