package com.mslk.hypermakina.code.dto;

import com.mslk.hypermakina.code.domain.entity.CodeMngEntity;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CodeMngDto {

    private Long id;

    private String codeType; // COMMENT 'CODE TYPE',

    private String codeEu; // COMMENT 'CODE 용도',

    private String codeGm; // COMMENT 'CODE Group',

    private String codeWm; // COMMENT 'CODE 업무명',

    private String codeNm; //  COMMENT 'CODE 이름',

    private String codeVm; //  COMMENT 'CODE 값',

    private String codeNote; //   COMMENT 'Code 비고',

    private String seTf; //COMMENT '사용유무',

    private String altEn;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    @Builder
    public CodeMngDto(Long id, String codeType, String codeEu, String codeGm, String codeWm, String codeNm, String codeVm,  String codeNote, String seTf, String altEn, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.codeType = codeType;
        this.codeEu = codeEu;
        this.codeGm = codeGm;
        this.codeWm = codeWm;
        this.codeNm = codeNm;
        this.codeVm = codeVm;
        this.codeNote = codeNote;
        this.seTf = seTf;
        this.altEn = altEn;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public CodeMngEntity toEntity() {

        CodeMngEntity codeMngEntity = CodeMngEntity.builder()
                .id(id)
                .codeType(codeType)
                .codeEu(codeEu)
                .codeGm(codeGm)
                .codeWm(codeWm)
                .codeNm(codeNm)
                .codeVm(codeVm)
                .codeNote(codeNote)
                .seTf(seTf)
                .altEn(altEn)
                .build();

        return codeMngEntity;
    }

}
