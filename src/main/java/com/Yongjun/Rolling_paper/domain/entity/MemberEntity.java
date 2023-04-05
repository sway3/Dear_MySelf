package com.Yongjun.Rolling_paper.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "Rolling_paper_member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(name = "birth_day")
    private Date date;

    @Builder
    public MemberEntity(Long id, String email, String password, String name, Date date) {

        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.date = date;
    }
}