package com.mslk.sns.position.dto;

import com.mslk.sns.position.domain.entity.PositionEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PositionDto {

    Long id; //'고유 인덱스'
    private String uid; // ' 부서 ID',

    private String name; // '부서명',

    private int seq; // '순서',

    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',

    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',

    private String memo; // '메모',

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private LocalDateTime deleteDate;


    public PositionEntity toEntity() {
        PositionEntity positionEntity = PositionEntity.builder()
                .uid(uid)
                .id(id)
                .name(name)
                .seq(seq)
                .syncUse(syncUse)
                .del(del)
                .memo(memo)
                .build();
        return positionEntity;
    }

    @Builder
    public PositionDto(Long id, String uid, String name,  int seq, int syncUse, int del, LocalDateTime createdDate, LocalDateTime modifiedDate, LocalDateTime deleteDate, String memo) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.seq = seq;
        this.syncUse = syncUse;
        this.del = del;
        this.memo = memo;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.deleteDate = deleteDate;
    }


}
