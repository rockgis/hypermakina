package com.mslk.restapi.domain.entity;

import com.mslk.common.domain.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "hyperrestapi")
public class HyperRestApiEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String restType;

    @Column(length = 50, nullable = false)
    private String restContent;

    @Column(length = 30, nullable = false)
    private String usrEn;

    @Column(length = 30, nullable = false)
    private String usrPw;

    @Column(length = 30, nullable = false)
    private String managerurl;

    private int egmmngid;

    @Column(length = 50, nullable = false)
    private String restServer;

    @Column(length = 50, nullable = false)
    private String restFunction;

    @Column(length = 50, nullable = false)
    private String restHttp;

    @Column(length = 1, nullable = false)
    private String seTf;

    @Column(length = 50, nullable = false)
    private String restSync;

    @Column(length = 50, nullable = false)
    private String syncTime;

    @Column(length = 30, nullable = false)
    private String altEn;


    @Builder
    public HyperRestApiEntity(Long id , String restType, String restContent, String usrEn, String usrPw, String managerurl, int egmmngid, String restServer, String restFunction, String restHttp, String seTf, String restSync, String syncTime, String altEn){
        this.id = id;
        this.restType = restType;
        this.restContent =restContent;
        this.usrEn = usrEn;
        this.usrPw = usrPw;
        this.managerurl = managerurl;
        this.egmmngid = egmmngid;
        this.restServer = restServer;
        this.restFunction = restFunction;
        this.restHttp = restHttp;
        this.seTf = seTf;
        this.restSync =restSync;
        this.syncTime = syncTime;
        this.altEn = altEn;

    }

}
