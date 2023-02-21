package com.mslk.sns.rank.domain.entity;

import com.mslk.sns.common.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_rank")
public class RankEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //'고유 인덱스'

    @Column(length = 50, nullable = false)
    private String uid; // ' 직책 ID',
    @Column(length = 50, nullable = false)
    private String name; // '직책명',

    @Column(nullable = false)
    private int seq; // '순서',

    @Column(nullable = false)
    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',

    @Column(nullable = false)
    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',

    @Column(columnDefinition = "TEXT")
    private String memo; // '메모',


    @Builder
    public RankEntity(Long id, String uid, String name, int seq, int syncUse, int del, String memo) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.seq = seq;
        this.syncUse = syncUse;
        this.del = del;
        this.memo = memo;
    }


}
