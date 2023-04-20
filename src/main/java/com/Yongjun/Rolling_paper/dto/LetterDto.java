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

    @NotEmpty(message = "제목을 입력해주세요")
    private String title;
    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;
    private String font;
    private String paper;

    private String writer;

    @Builder
    public LetterDto(Long id, String content, String font, String paper, String title, String writer) {
        this.id = id;
        this.content = content;
        this.font = font;
        this.paper = paper;
        this.title = title;
        this.writer = writer;
    }
}
