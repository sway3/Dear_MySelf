package com.Yongjun.Rolling_paper.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name = "Rolling_Paper_letter1234567")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    @Size(max = 2000)
    private String content;


    @Column(nullable = false)
    private String font;

    @Column(nullable = false)
    private String paper;

    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Member member;

    @Builder
    public Letter(String title, String content, String font, String paper, String writer, Member member) {
        this.title = title;
        this.content = content;
        this.font = font;
        this.paper = paper;
        this.writer = writer;
        this.member = member;
    }

    // Getters and setters
}
