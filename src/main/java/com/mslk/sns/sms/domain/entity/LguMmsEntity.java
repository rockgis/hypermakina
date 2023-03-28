package com.mslk.sns.sms.domain.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "lgusms.MMS_MSG")
public class LguMmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    //보내려는 메세지 SMS 단문 전송 가능 용량은 90byte 입니다.
    //
    //MMS 전송 가능용량은 2000byte 입니다.
    //
    //
    //
    //DB Insert 적용시 줄바꿈 문자 최대한 활용하여 적용 바랍니다.
    //
    //--> \r , \n 추가시 줄바꿈 적용되니 참고 바랍니다.
    //
    //
    //
    //INSERT INTO MMS_MSG (SUBJECT, PHONE, CALLBACK, STATUS, REQDATE, MSG, TYPE) VALUES
    //
    //('[다동 ICT 7라인 핀 고장3]', '01023796894', '0318859833', '0',
    //
    //NOW(), '공장 : 여주SNS \n\r라인 : 라인명 \n\r공정 : 공정명 \n\r설비 : 설비 ID \n\r담당자 : 담당자 이름 \n\r호출 항목 : ICT 7라인 핀 고장 \n\r요청 내용 :\n\rICT 7라인 핀 고장', '0');
    @Column(length = 120, nullable = false)
    private String subject;
    @Column(length = 15, nullable = false)
    private String phone;
    @Column(length = 15, nullable = false)
    private String callback;
    @Column(length = 2, nullable = false)
    private String status;
    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime reqdate;
    @Column(length = 4000, nullable = false)
    private String msg;
    @Column(length = 2, nullable = false)
    private String type;

    @Builder
    public LguMmsEntity(String subject, String phone, String callback, String status, LocalDateTime reqdate, String msg , String type){
        this.subject = subject;
        this.phone = phone;
        this.callback = callback;
        this.status = status;
        this.reqdate = reqdate;
        this.msg = msg;
        this.type = type;
    }


    public LguMmsEntity() {

    }
}
