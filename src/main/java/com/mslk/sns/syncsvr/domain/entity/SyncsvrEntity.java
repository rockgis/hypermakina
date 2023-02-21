package com.mslk.sns.syncsvr.domain.entity;

import com.mslk.sns.common.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_sync_svr")
public class SyncsvrEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //'고유 인덱스'

    @Column(length = 50, nullable = false)
    private String uid; // ' 서버 ID',
    @Column(length = 50, nullable = false)
    private String name; // '서버명',

    @Column(length = 50, nullable = false)
    private String ip; // '서버 IP',

    @Column(length = 50, nullable = false)
    private String modiId; // '마지막 데이터 생성 , 수정 ,삭제자',

    @Column(nullable = false)
    private int seq; // '순서',

    @Column(nullable = false)
    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',

    @Column(nullable = false)
    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',

    @Column(columnDefinition = "TEXT")
    private String memo; // '메모',


    @Builder
    public SyncsvrEntity(Long id, String uid, String name, String ip, String modiId, int seq, int syncUse, int del, String memo) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.ip = ip;
        this.modiId = modiId;
        this.seq = seq;
        this.syncUse = syncUse;
        this.del = del;
        this.memo = memo;
    }


}
