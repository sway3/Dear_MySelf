package com.Yongjun.Rolling_paper.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Slf4j

@Table(name = "Rolling_paper_member")
public class MemberEntity {
    @Id
    @GeneratedValue
    @Column(name = "MemberId")
    private Long id;



    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "phone_number")
    private String phone_number;

    @Builder
    public MemberEntity(Long id, String email, String password, String name, String phone_number) {

        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
    }
}