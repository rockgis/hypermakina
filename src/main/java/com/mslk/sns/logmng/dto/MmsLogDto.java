package com.mslk.sns.logmng.dto;

import com.mslk.sns.logmng.domain.entity.MmsLogEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MmsLogDto {

    private Long id; //'등록순번'


    private String mmsTel; // '번호',

    private String mmsSub; // '제목',

    private String mmsContent ;//'내용',


    private LocalDateTime createdDate;



    public MmsLogEntity toEntity(){
        MmsLogEntity gitta0001Entity = MmsLogEntity.builder()
                .id(id)
                .mmsTel(mmsTel)
                .mmsSub(mmsSub)
                .mmsContent(mmsContent)
                .build();
        return gitta0001Entity;
    }

    @Builder
    public MmsLogDto(Long id, String mmsTel, String mmsSub, String mmsContent, LocalDateTime createdDate) {
        this.id = id;
        this.mmsTel = mmsTel;
        this.mmsSub = mmsSub;
        this.mmsContent = mmsContent;
        this.createdDate = createdDate;
    }
}
