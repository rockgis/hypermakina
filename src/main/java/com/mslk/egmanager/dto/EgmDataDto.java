package com.mslk.egmanager.dto;

import com.mslk.egmanager.domain.entity.EgmDataEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EgmDataDto {

    private Long id;
    private int metaId;    /// 'FOREIGN Key ',

    private String restName; // 'REST API 이름',

    private String componentName; // 'componentName',

    private String startDate; // 'startDate',

    private String endDate; // 'endDate',

    private String test; // 'test',

    private String info; // 'info',

    private String componentType; // 'componentType',

    private String timeline; // 'timeline',

    private String measure; // 'measure',

    private String seTf;

    private String altEn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    @Builder
    public EgmDataDto(Long id, int metaId, String restName, String componentName, String startDate, String endDate, String test, String info, String componentType, String timeline, String measure, String seTf, String altEn, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.metaId = metaId;
        this.restName = restName;
        this.componentName = componentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.test = test;
        this.info = info;
        this.componentType = componentType;
        this.timeline = timeline;
        this.measure = measure;
        this.seTf = seTf;
        this.altEn = altEn;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public EgmDataEntity toEntity() {

        EgmDataEntity egmDataEntity = EgmDataEntity.builder()
                .id(id)
                .metaId(metaId)
                .restName(restName)
                .componentName(componentName)
                .startDate(startDate)
                .endDate(endDate)
                .test(test)
                .info(info)
                .componentType(componentType)
                .timeline(timeline)
                .measure(measure)
                .seTf(seTf)
                .altEn(altEn)
                .build();

        return egmDataEntity;
    }


}
