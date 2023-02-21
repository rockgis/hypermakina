package com.mslk.sns.syncsvr.dto;

import com.mslk.sns.syncsvr.domain.entity.SyncsvrEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SyncsvrDto {

    Long id; //'고유 인덱스'
    private String uid; // ' 서버 ID',

    private String name; // '서버명',

    private String ip; // '사버 ip',

    private String modiId; // '마지막 데이터 생성 , 수정 ,삭제자',

    private int seq; // '순서',

    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',

    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',

    private String memo; // '메모',

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private LocalDateTime deleteDate;


    public SyncsvrEntity toEntity() {
        SyncsvrEntity syncsvrEntity = SyncsvrEntity.builder()
                .uid(uid)
                .id(id)
                .name(name)
                .ip(ip)
                .modiId(modiId)
                .seq(seq)
                .syncUse(syncUse)
                .del(del)
                .memo(memo)
                .build();
        return syncsvrEntity;
    }

    @Builder
    public SyncsvrDto(Long id, String uid, String name, String ip, String modiId ,int seq, int syncUse, int del, LocalDateTime createdDate, LocalDateTime modifiedDate, LocalDateTime deleteDate, String memo) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.ip = ip;
        this.modiId = modiId;
        this.seq = seq;
        this.syncUse = syncUse;
        this.del = del;
        this.memo = memo;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.deleteDate = deleteDate;
    }


}
