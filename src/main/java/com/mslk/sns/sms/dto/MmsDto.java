package com.mslk.sns.sms.dto;

import com.mslk.sns.sms.domain.entity.LguMmsEntity;
import com.mslk.sns.sms.domain.entity.MmsEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MmsDto {

    private Long id;

    private Long codemng_id;

    private String subject;
    private String phone;
    private String callback;
    private String status;
    private String msg;

    private String type;

    private String memo;




    public MmsEntity toEntity() {
        MmsEntity mmsEntity = MmsEntity.builder()
                .id(id)
                .codemng_id(codemng_id)
                .subject(subject)
                .phone(phone)
                .callback(callback)
                .status(status)
                .msg(msg)
                .type(type)
                .memo(memo)
                .build();
        return mmsEntity;
    }

    @Builder
    public MmsDto(Long id,Long codemng_id, String subject, String phone, String callback, String status, String msg , String type,String memo){
        this.id = id;
        this.codemng_id = codemng_id;
        this.subject = subject;
        this.phone = phone;
        this.callback = callback;
        this.status = status;
        this.msg = msg;
        this.type = type;
        this.memo = memo;
    }


}
