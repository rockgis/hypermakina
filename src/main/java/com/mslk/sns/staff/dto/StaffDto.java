package com.mslk.sns.staff.dto;

import com.mslk.sns.staff.domain.entity.StaffEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StaffDto {

    Long id; //'고유 인덱스'
    private String uid; // ' login ID',
    private String name; // '부서명',
    private String fName; // '사원 이름',
    private String lName; // '사원 성',
    private String fullName; // '사원 전체 이름',
    private String identityNo; // '사원 번호',
    private String pw; // '비밀번호',
    private String sex; // '성별(남/여)',
    private String rankId; // '직급 ID',
    private String positionId; // '직책 ID',
    private String departmentId; // '부서 ID',
    private int head; // '부서장 유무 (0/1 , FALSE/TRUE)',
    private String utype; // '사용자 유형(Admin,User,OP) default : User',
    private String auth; // '사용자 권한 (S,R,L,C)',
    private String concurrentPosition; // '겸직',
    private String userId; // '겸직 사용자 아이디',
    private String eMail; // 'E-mail',
    private String hp; // '연락처',
    private int seq; // '순서',
    private int syncUse; // '동기화 유무 (0/1 , FALSE/TRUE)',
    private String syncSystem; // '동기화시스템 (,)',
    private String fingerPrint; // '지문정보',
    private String cardNo; // '카드정보',
    private int del; // '삭제 유무(0/1 , FALSE/TRUE)',
    private String memo; // '메모',

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private LocalDateTime deleteDate;


    public StaffEntity toEntity() {
        StaffEntity staffEntity = StaffEntity.builder()
                .uid(uid)
                .id(id)
                .name(name)
                .fName(fName)
                .lName(lName)
                .fullName(fullName)
                .identityNo(identityNo)
                .pw(pw)
                .sex(sex)
                .rankId(rankId)
                .positionId(positionId)
                .departmentId(departmentId)
                .head(head)
                .utype(utype)
                .auth(auth)
                .concurrentPosition(concurrentPosition)
                .userId(userId)
                .eMail(eMail)
                .hp(hp)
                .seq(seq)
                .syncUse(syncUse)
                .syncSystem(syncSystem)
                .fingerPrint(fingerPrint)
                .cardNo(cardNo)
                .del(del)
                .memo(memo)
                .build();
        return staffEntity;
    }

    @Builder
    public StaffDto(Long id, String uid, String name, String fName, String lName, String fullName, String identityNo, String pw, String sex, String rankId, String positionId, String departmentId, int head, String utype, String auth, String concurrentPosition, String userId, String eMail, String hp, int seq, int syncUse, String syncSystem, String fingerPrint, String cardNo, int del, LocalDateTime createdDate, LocalDateTime modifiedDate, LocalDateTime deleteDate, String memo) {
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
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.deleteDate = deleteDate;
    }


}
