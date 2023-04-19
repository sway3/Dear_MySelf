package com.Yongjun.Rolling_paper.dto;

import com.Yongjun.Rolling_paper.domain.entity.LetterEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LetterDto {
    private Long id;
    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;
    private String font;
    private String paper;


    @Builder
    public LetterDto(Long id, String content, String font, String paper) {
        this.id = id;
        this.content = content;
        this.font = font;
        this.paper = paper;
    }
}
