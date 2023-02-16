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
@Table(name = "MSLKMEMBER")
public class MemberEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true , nullable = false)
    private String email;

    @Column(length = 20,unique = true , nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Builder
    public MemberEntity(Long id, String email, String name, String password, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    public MemberEntity update(String email, String name){
        this.email = email;
        this.name = name;
        return this;
    }
}