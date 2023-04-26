package com.Yongjun.Rolling_paper.domain.entity;

import lombok.*;

import javax.persistence.*;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
@Table(name = "Rolling_Paper_letter123")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String font;

    @Column(nullable = false)
    private String paper;

    private String writer;

    @Builder
    public Letter(String title, String content, String font, String paper, String writer) {
        this.title = title;
        this.content = content;
        this.font = font;
        this.paper = paper;
        this.writer = writer;
    }

    // Getters and setters
}
