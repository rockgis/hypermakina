package com.mslk.sns.staff.domain.entity;

import com.mslk.hypermakina.member.domain.Role;
import com.mslk.sns.common.TimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_staff")
public class StaffEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //'고유 인덱스'

    @Column(length = 50, nullable = false)
    private String uid; // ' login ID',
    @Column(length = 50, nullable = false)
    private String name; // '부서명',
    @Column(length = 50, nullable = false)
    private String fName; // '사원 이름',

    @Column(length = 50, nullable = false)
    private String lName; // '사원 성',

    @Column(length = 50, nullable = false)
    private String fullName; // '사원 전체 이름',

    @Column(length = 50, nullable = false)
    private String identityNo; // '사원 번호',

    @Column(length = 100, nullable = false)
    private String pw; // '비밀번호',

    @Column(length = 50, nullable = false)
    private String sex; // '성별(남/여)',

    @Column(length = 50, nullable = false)
    private String rankId; // '직급 ID',

    @Column(length = 50, nullable = false)
    private String positionId; // '직책 ID',

    @Column(length = 50, nullable = false)
    private String departmentId; // '부서 ID',
    private int head; // '부서장 유무 (0/1 , FALSE/TRUE)',

    @Column(length = 50, nullable = false)
    private String utype; // '사용자 유형(Admin,User,OP) default : User',

    @Column(length = 50, nullable = false)
    private String auth; // '사용자 권한 (S,R,L,C)',

    @Column(length = 50, nullable = false)
    private String concurrentPosition; // '겸직',

    @Column(length = 50, nullable = false)
    private String userId; // '겸직 사용자 아이디',

    @Column(length = 50, nullable = false)
    private String eMail; // 'E-mail',

    @Column(length = 50, nullable = false)
    private String hp; // '연락처',

    @Column(nullable = false)
    private int seq; // '순서',

    @Column(nullable = false)
    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',

    @Column(length = 50, nullable = false)
    private String syncSystem; // '동기화시스템 (,)',

    @Column(length = 50, nullable = false)
    private String fingerPrint; // '지문정보',

    @Column(length = 50, nullable = false)
    private String cardNo; // '카드정보',

    @Column(nullable = false)
    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',

    @Column(columnDefinition = "TEXT")
    private String memo; // '메모',

    @Column(length = 100, nullable = false)
    private String password;



    @Builder
    public StaffEntity(Long id, String uid, String name, String fName, String lName, String fullName, String identityNo, String pw, String sex, String rankId, String positionId, String departmentId, int head, String utype, String auth, String concurrentPosition, String userId, String eMail, String hp, int seq, int syncUse, String syncSystem, String fingerPrint, String cardNo, int del, String memo,String password) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.fName = fName;
        this.lName = lName;
        this.fullName = fullName;
        this.identityNo = identityNo;
        this.pw = pw;
        this.sex = sex;
        this.rankId = rankId;
        this.positionId = positionId;
        this.departmentId = departmentId;
        this.head = head;
        this.utype = utype;
        this.auth = auth;
        this.concurrentPosition = concurrentPosition;
        this.userId = userId;
        this.eMail = eMail;
        this.hp = hp;
        this.seq = seq;
        this.syncUse = syncUse;
        this.syncSystem = syncSystem;
        this.fingerPrint = fingerPrint;
        this.cardNo = cardNo;
        this.del = del;
        this.memo = memo;
        this.password = password;
    }


}
