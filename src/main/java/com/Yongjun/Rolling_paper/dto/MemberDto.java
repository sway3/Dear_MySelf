package com.Yongjun.Rolling_paper.dto;


import com.Yongjun.Rolling_paper.domain.entity.Member;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    @NotEmpty(message = "이메일 입력은 필수입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;
    @NotEmpty(message = "비밀번호 입력은 필수입니다.")
    private String password;
    private String name;
    private String phone_number;



    public Member toEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phoneNumber(phone_number)
                .build();
    }

}
