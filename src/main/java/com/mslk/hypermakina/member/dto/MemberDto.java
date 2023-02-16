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
    private String email;

    private String name;

    private Role role;
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .name(name)
                .password(password)
                .role(Role.MEMBER)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String name, String password,Role role,LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
