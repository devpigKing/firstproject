package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자 자동 생성
@ToString // toString() 메서드 생성
public class ArticleForm {
    private Long id;
    private String title; // 제목을 받을 필드
    private String content; // 내용을 받을 필드

//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

//    // 데이터를 잘 받았는지 체크할 toString()
//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public Article toEntity() {
        return new Article(id , title, content);
    }
}
