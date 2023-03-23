package com.mslk.sns.concurrent.domain.entity;

import com.mslk.sns.common.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_concurrent")
public class ConcurrentEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //'고유 인덱스'

    @Column(length = 50, nullable = false)
    private String uid; // ' login ID',
    @Column(length = 50, nullable = false)
    private String name; // '이름',

    @Column(length = 50, nullable = false)
    private String rankId; // '직급 ID',

    @Column(length = 50, nullable = false)
    private String positionId; // '직책 ID',

    @Column(length = 50, nullable = false)
    private String departmentId; // '부서 ID',
    private int head; // '부서장 유무 (0/1 , FALSE/TRUE)',
    @Column(nullable = false)
    private int seq; // '순서',

    @Column(nullable = false)
    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',

    @Column(nullable = false)
    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',

    @Column(columnDefinition = "TEXT")
    private String memo; // '메모',


    @Builder
    public ConcurrentEntity(Long id, String uid, String name, String rankId, String positionId, String departmentId, int head, int seq, int syncUse, int del, String memo) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.rankId = rankId;
        this.positionId = positionId;
        this.departmentId = departmentId;
        this.head = head;
        this.seq = seq;
        this.syncUse = syncUse;
        this.del = del;
        this.memo = memo;
    }


}
