package com.mslk.sns.department.domain.entity;

import com.mslk.sns.common.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_department")
public class DepartmentEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //'고유 인덱스'

    @Column(length = 50, nullable = false)
    private String uid; // ' 부서 ID',
    @Column(length = 50, nullable = false)
    private String name; // '부서명',
    @Column(length = 50, nullable = false)
    private String upperId; // '상위부서 ID',

    @Column(length = 50, nullable = false)
    private String lftId; // 'Neseted Set Model 좌측 ID',

    @Column(length = 50, nullable = false)
    private String rgtId; // 'Nelgusmsseted Set Model 우측 ID',

    @Column(length = 50, nullable = false)
    private String depth; // 'Depth',


    @Column(nullable = false)
    private int seq; // '순서',

    @Column(nullable = false)
    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',

    @Column(length = 50, nullable = false)
    private String treeId; // 'Full Tree ID',

    private int root; // '최상위 유무(0/1 , FALSE/TRUE)',

    @Column(nullable = false)
    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',

    @Column(columnDefinition = "TEXT")
    private String memo; // '메모',


    @Builder
    public DepartmentEntity(Long id, String uid, String name, String upperId, String lftId, String rgtId, String depth, int seq, int syncUse, String treeId, int root, int del, String memo) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.upperId = upperId;
        this.lftId = lftId;
        this.rgtId = rgtId;
        this.depth = depth;
        this.seq = seq;
        this.syncUse = syncUse;
        this.treeId = treeId;
        this.root = root;
        this.del = del;
        this.memo = memo;
    }


}
