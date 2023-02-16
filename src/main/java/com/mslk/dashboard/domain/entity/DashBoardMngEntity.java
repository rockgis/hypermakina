package com.mslk.dashboard.domain.entity;

import com.mslk.common.domain.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "DASHBOARDMNG")
public class DashBoardMngEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String dsbType; //COMMENT 'DashBoard TYPE',

    @Column(length = 50, nullable = false)
    private String dsbNm; //  COMMENT 'DashBoard 이름',

    @Column(length = 30, nullable = false)
    private String dsbEu; //COMMENT 'DashBoard 용도',

    @Column(length = 30, nullable = false)
    private String dsbGm; //COMMENT 'DashBoard Group',

    @Column(length = 30, nullable = false)
    private String dsbWm; //COMMENT 'DashBoard 업무명',

    @Column(length = 30, nullable = false)
    private String dsbUrl; //COMMENT 'SuperSet 연결 URL',

    @Column(length = 30, nullable = false)
    private String dsbNote; // COMMENT 'META Host 비고',

    @Column(length = 1, nullable = false)
    private String seTf; //COMMENT '사용유무',

    @Column(length = 30, nullable = false)
    private String altEn;


    @Builder
    public DashBoardMngEntity(Long id , String dsbType, String dsbNm, String dsbEu, String dsbGm, String dsbWm, String dsbUrl, String seTf, String dsbNote, String altEn){
        this.id = id;
        this.dsbType = dsbType;
        this.dsbNm =dsbNm;
        this.dsbEu = dsbEu;
        this.dsbGm = dsbGm;
        this.dsbWm = dsbWm;
        this.dsbUrl = dsbUrl;
        this.seTf = seTf;
        this.dsbNote = dsbNote;
        this.altEn = altEn;

    }

}
