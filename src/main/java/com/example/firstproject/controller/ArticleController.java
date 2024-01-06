package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j // 로깅 기능을 위한 어노테이션 추가
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
        //System.out.println(form.toString());
        log.info(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());
        // 2. 레포지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article 엔티티를 저장해 saved 객체에 반환
        //System.out.println(article.toString());
        log.info(article.toString());

        return "redirect:/articles";
    }

    @GetMapping("/articles/{id}") // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        // 1. id를 조회해 DB에서 해당 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("article", articleEntity);
        // 3. 조회한 데이터를 사용자에게 보여 주기 위한 뷰 페이지 만들고 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. DB에서 모든 Article 데이터 가져오기
        List<Article> articles = articleRepository.findAll();
        // 2. 가져온 Article 묶음을 모델에 등록하기
        model.addAttribute("articles", articles);
        // 3. 사용자에게 보여 줄 뷰 페이지 설정하기
        return "articles/index";
    }
}
