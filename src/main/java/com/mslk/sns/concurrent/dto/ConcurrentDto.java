package com.mslk.sns.concurrent.dto;

import com.mslk.sns.concurrent.domain.entity.ConcurrentEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ConcurrentDto {

    Long id; //'고유 인덱스'
    private String uid; // ' login ID',
    private String name; // '부서명',
    private String rankId; // '직급 ID',
    private String positionId; // '직책 ID',
    private String departmentId; // '부서 ID',
    private int head; // '부서장 유무 (0/1 , FALSE/TRUE)',
    private int seq; // '순서',
    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',
    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',
    private String memo; // '메모',

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private LocalDateTime deleteDate;


    public ConcurrentEntity toEntity() {
        ConcurrentEntity concurrentEntity = ConcurrentEntity.builder()
                .uid(uid)
                .id(id)
                .name(name)
                .rankId(rankId)
                .positionId(positionId)
                .departmentId(departmentId)
                .head(head)
                .seq(seq)
                .syncUse(syncUse)
                .del(del)
                .memo(memo)
                .build();
        return concurrentEntity;
    }

    @Builder
    public ConcurrentDto(Long id, String uid, String name, String rankId, String positionId, String departmentId, int head, int seq, int syncUse, int del, LocalDateTime createdDate, LocalDateTime modifiedDate, LocalDateTime deleteDate, String memo) {
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
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.deleteDate = deleteDate;
    }


}
