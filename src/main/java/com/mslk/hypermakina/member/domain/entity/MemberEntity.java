package com.mslk.hypermakina.member.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.mslk.hypermakina.member.domain.Role;

import javax.persistence.*;

import com.mslk.common.domain.TimeEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_staff")
public class MemberEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true , nullable = false)
    private String uid;

    @Column(length = 20,unique = true , nullable = false)
    private String fullName;

    @Column(length = 100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Builder
    public MemberEntity(Long id, String uid, String fullName, String password, Role role) {
        this.id = id;
        this.uid = uid;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    public MemberEntity update(String uid, String fullName){
        this.uid = uid;
        this.fullName = fullName;
        return this;
    }
}