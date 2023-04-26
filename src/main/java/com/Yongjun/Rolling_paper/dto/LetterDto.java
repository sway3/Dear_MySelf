package com.Yongjun.Rolling_paper.dto;

import com.Yongjun.Rolling_paper.domain.entity.Letter;
import com.Yongjun.Rolling_paper.domain.entity.Member;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LetterDto {

    @NotEmpty(message = "제목을 입력해주세요")
    private String title;
    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;
    private String font;
    private String paper;

    private String writer;
    private Member member;

    public Letter toEntity() {
        return Letter.builder()
                .title(title)
                .writer(writer)
                .content(content)
                .paper(paper)
                .font(font)
                .member(member)
                .build();
    }

}
