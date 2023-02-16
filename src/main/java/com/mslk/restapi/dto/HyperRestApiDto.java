package com.mslk.restapi.dto;

import com.mslk.restapi.domain.entity.HyperRestApiEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HyperRestApiDto {

    private Long id;

    private String restType;

    private String restContent;

    private String usrEn;

    private String usrPw;

    private String contentType;

    private String accept;

    private String restServer;

    private String restFunction;

    private String restHttp;

    private String seTf;

    private String restSync;

    private String syncTime;

    private String altEn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    @Builder
    public HyperRestApiDto(Long id,String restType, String restContent, String usrEn, String usrPw, String contentType, String accept, String restServer, String restFunction, String restHttp, String seTf, String restSync, String syncTime, String altEn, LocalDateTime createdDate , LocalDateTime modifiedDate){

        this.id = id;
        this.restType = restType;
        this.restContent = restContent;
        this.usrEn = usrEn;
        this.usrPw = usrPw;
        this.contentType = contentType;
        this.accept = accept;
        this.restServer = restServer;
        this.restFunction = restFunction;
        this.restHttp = restHttp;
        this.seTf = seTf;
        this.restSync =restSync;
        this.syncTime = syncTime;
        this.altEn = altEn;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;



    }


    public HyperRestApiEntity toEntity(){

        HyperRestApiEntity hyperrestapiEntity = HyperRestApiEntity.builder()
                .id(id)
                .restType(restType)
                .restContent(restContent)
                .usrEn(usrEn)
                .usrPw(usrPw)
                .contentType(contentType)
                .accept(accept)
                .restServer(restServer)
                .restFunction(restFunction)
                .restHttp(restHttp)
                .seTf(seTf)
                .restSync(restSync)
                .syncTime(syncTime)
                .altEn(altEn)
                .build();

        return hyperrestapiEntity;
    }
}
