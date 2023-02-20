package com.mslk.sns.department.dto;

import com.mslk.sns.department.domain.entity.DepartmentEntity;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DepartmentDto {

    Long id; //'고유 인덱스'
    private String uid; // ' 부서 ID',

    private String name; // '부서명',

    private String upperId; // '상위부서 ID',

    private String lftId; // 'Neseted Set Model 좌측 ID',

    private String rgtId; // 'Nelgusmsseted Set Model 우측 ID',

    private String depth; // 'Depth',

    private int seq; // '순서',

    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',

    private String treeId; // 'Full Tree ID',

    private int root; // '최상위 유무(0/1 , FALSE/TRUE)',

    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',

    private String memo; // '메모',

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private LocalDateTime deleteDate;


    public DepartmentEntity toEntity() {
        DepartmentEntity departmentEntity = DepartmentEntity.builder()
                .uid(uid)
                .id(id)
                .name(name)
                .upperId(upperId)
                .lftId(lftId)
                .rgtId(rgtId)
                .depth(depth)
                .seq(seq)
                .syncUse(syncUse)
                .treeId(treeId)
                .root(root)
                .del(del)
                .memo(memo)
                .build();
        return departmentEntity;
    }

    @Builder
    public DepartmentDto(Long id, String uid, String name, String upperId, String lftId, String rgtId, String depth, int seq, int syncUse, String treeId, int root, int del, LocalDateTime createdDate, LocalDateTime modifiedDate, LocalDateTime deleteDate, String memo) {
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
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.deleteDate = deleteDate;
    }


}
