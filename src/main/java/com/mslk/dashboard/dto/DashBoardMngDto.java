package com.mslk.dashboard.dto;

import com.mslk.dashboard.domain.entity.DashBoardMngEntity;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DashBoardMngDto {

    private Long id;

    private String dsbType; //COMMENT 'DashBoard TYPE',

    private String dsbNm; //  COMMENT 'DashBoard 이름',

    private String dsbEu; //COMMENT 'DashBoard 용도',

    private String dsbGm; //COMMENT 'DashBoard Group',

    private String dsbWm; //COMMENT 'DashBoard 업무명',

    private String dsbUrl; //COMMENT 'SuperSet 연결 URL',

    private String seTf; //COMMENT '사용유무',

    private String dsbNote; // COMMENT 'META Host 비고',

    private String altEn;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public DashBoardMngDto(Long id, String dsbType, String dsbNm, String dsbEu, String dsbGm, String dsbWm, String dsbUrl, String seTf, String dsbNote, String altEn, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.dsbType = dsbType;
        this.dsbNm = dsbNm;
        this.dsbEu = dsbEu;
        this.dsbGm = dsbGm;
        this.dsbWm = dsbWm;
        this.dsbUrl = dsbUrl;
        this.seTf = seTf;
        this.dsbNote = dsbNote;
        this.altEn = altEn;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public DashBoardMngEntity toEntity() {

        DashBoardMngEntity dashBoardMngEntity = DashBoardMngEntity.builder()
                .id(id)
                .dsbType(dsbType)
                .dsbNm(dsbNm)
                .dsbEu(dsbEu)
                .dsbGm(dsbGm)
                .dsbWm(dsbWm)
                .dsbUrl(dsbUrl)
                .dsbNote(dsbNote)
                .seTf(seTf)
                .altEn(altEn)
                .build();

        return dashBoardMngEntity;
    }


}
