package com.Yongjun.Rolling_paper.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Letter")
public class LetterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LetterId")
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

    // Getters and setters
}
