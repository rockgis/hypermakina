package com.mslk.hypermakina.member.dto;

import com.mslk.hypermakina.member.domain.entity.MemberEntity;
import com.mslk.hypermakina.member.domain.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String uid;

    private String fullName;

    private Role role;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .uid(uid)
                .fullName(fullName)
                .password(password)
                .role(Role.MEMBER)
                .build();
    }

    @Builder
    public MemberDto(Long id, String uid, String fullName, String password,Role role,LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.uid = uid;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
    }
}
