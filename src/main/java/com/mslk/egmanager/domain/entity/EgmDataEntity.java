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
@Table(name = "egmmetadata")
public class EgmDataEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long metaId ;    /// 'FOREIGN Key ',

    @Column(length = 50, nullable = false)
    private String restName; // 'REST API 이름',
    @Column(length = 50, nullable = false)
    private String componentName; // 'componentName',
    @Column(length = 50, nullable = false)
    private String test; // 'test',
    @Column(length = 50, nullable = false)
    private String info; // 'info',
    @Column(length = 50, nullable = false)
    private String componentType; // 'componentType',
    @Column(length = 50, nullable = false)
    private String timeline; // 'timeline',
    @Column(length = 50, nullable = false)
    private String measure; // 'measure',

    @Column(length = 1, nullable = false)
    private String seTf;

    @Column(length = 30, nullable = false)
    private String altEn;


    @Builder
    public EgmDataEntity(Long id , Long metaId , String restName,String componentName, String test, String info, String componentType,String timeline,String measure,String seTf,String altEn){
        this.id = id;
        this.metaId = metaId;
        this.restName =restName;
        this.componentName = componentName;
        this.test = test;
        this.info = info;
        this.componentType = componentType;
        this.timeline = timeline;
        this.measure = measure;
        this.seTf = seTf;
        this.altEn = altEn;

    }

}
