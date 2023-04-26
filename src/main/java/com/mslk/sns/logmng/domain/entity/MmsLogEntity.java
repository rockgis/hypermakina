package com.mslk.sns.logmng.domain.entity;

//'사용자관리'

import com.mslk.common.domain.TimeCEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_mmslog")
public class MmsLogEntity extends TimeCEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id; //'등록순번'

    @Column(length = 30, nullable = false)
    private String mmsTel; // DCD         VARCHAR(30) COMMENT '번호',

    @Column(length = 30, nullable = false)
    private String mmsSub; //  USR_NM      VARCHAR(30) COMMENT '제목',

    @Column( length = 200, nullable = false)
    private String mmsContent;//  REQ_NM      VARCHAR(200) COMMENT '내용',

    @Builder
    public MmsLogEntity(Long id, String mmsTel, String mmsSub, String mmsContent) {
        this.id = id;
        this.mmsTel = mmsTel;
        this.mmsSub = mmsSub;
        this.mmsContent = mmsContent;
    }
}
