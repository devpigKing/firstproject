package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 1. 엔티티임을 선언, 이 어노테이션이 붙은 클래스를 기반으로 DB에 테이블이 생성됨.
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Article {
    @Id // 3. 엔티티의 대표값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성. 기본키 생성은 DB가
    private Long id;

    @Column // 2. title 필드 선언
    private String title;

    @Column // 2. content 필드 선언
    private String content;

//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }

//    public Article() {
//
//    }

//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
}
