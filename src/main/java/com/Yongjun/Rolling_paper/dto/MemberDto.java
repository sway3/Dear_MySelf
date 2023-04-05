package com.Yongjun.Rolling_paper.dto;


import com.Yongjun.Rolling_paper.domain.entity.MemberEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    @NotEmpty(message = "이메일 입력은 필수입니다.")
    private String email;
    @NotEmpty(message = "비밀번호 입력은 필수입니다.")
    private String password;
    private String name;
    private String phone_number;


    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .phone_number(phone_number)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String name, String phone_number) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone_number = phone_number;
    }
}
