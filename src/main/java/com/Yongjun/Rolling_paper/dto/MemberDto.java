package com.Yongjun.Rolling_paper.dto;


import com.Yongjun.Rolling_paper.domain.entity.MemberEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;

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
    private Date date;
//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .date(date)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String name, Date date) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.date = date;
    }
}
