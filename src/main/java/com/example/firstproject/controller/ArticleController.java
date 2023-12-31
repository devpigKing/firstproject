package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입, 의존성 주입
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {

        return "articles/new";
    }

    @PostMapping("/articles/create") // URL 요청 접수
    public String createArticle(ArticleForm form) { // 메서드 생성 및 반환값 작성
        System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());
        // 2. 레포지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        System.out.println(article.toString());

        return "";
    }
}
