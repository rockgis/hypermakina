package com.mslk.hypermakina.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN","관리자"),
    MEMBER("ROLE_MEMBER","사용자");

    private String Key;
    private String title;
}