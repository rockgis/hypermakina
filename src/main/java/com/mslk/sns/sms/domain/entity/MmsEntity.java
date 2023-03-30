package com.mslk.sns.sms.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_mms_code")
public class MmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //'고유 인덱스'


    private Long codemng_id;

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
    @Column(length = 4000, nullable = false)
    private String msg;
    @Column(length = 2, nullable = false)
    private String type;

    @Column(columnDefinition = "TEXT")
    private String memo; // '메모',

    @Builder
    public MmsEntity(Long id,Long codemng_id, String subject, String phone, String callback, String status, String msg , String type,String memo){
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
