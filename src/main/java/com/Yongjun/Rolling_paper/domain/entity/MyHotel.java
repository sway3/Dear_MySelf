package com.Yongjun.Rolling_paper.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Letter")
public class MyHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String content;

    // default constructor
    public MyHotel() {}

    // constructor with parameters
    public MyHotel(String link, String content) {
        this.link = link;
        this.content = content;
    }

}