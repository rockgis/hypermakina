package com.mslk.sns.sms.dto;

import com.mslk.sns.sms.domain.entity.LguMmsEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LguMmsDto {

    private String subject;
    private String phone;
    private String callback;
    private String status;
    private LocalDateTime reqdate;
    private String msg;
    private String type;

    public LguMmsEntity toEntity() {
        LguMmsEntity lguMmsEntity = LguMmsEntity.builder()
                .subject(subject)
                .phone(phone)
                .callback(callback)
                .status(status)
                .reqdate(reqdate)
                .msg(msg)
                .type(type)
                .build();
        return lguMmsEntity;
    }

    @Builder
    public LguMmsDto(String subject, String phone, String callback, String status, LocalDateTime reqdate, String msg , String type){
        this.subject = subject;
        this.phone = phone;
        this.callback = callback;
        this.status = status;
        this.reqdate = reqdate;
        this.msg = msg;
        this.type = type;
    }


}
