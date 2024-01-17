package com.heima.article.controller.v1;

import com.heima.article.config.ArticleConfiguration;
import com.heima.article.entity.dto.ArticleInfoDto;
import com.heima.article.service.ApArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/article")
@EnableConfigurationProperties(ArticleConfiguration.class)
public class ArticleHomeController {
    @Autowired
    private ArticleConfiguration articleConfiguration;
    @Autowired
    private ApArticleService apArticleService;
//    @CrossOrigin(origins = "http://localhost:63342")
    @Cacheable("articlesLoad")
    @PostMapping("/load")
    public ResponseResult load(@RequestBody ArticleHomeDto dto) {
        return apArticleService.load(ArticleConstants.LOADTYPE_LOAD_MORE,dto);
    }
    @Cacheable("articlesLoad")
    @PostMapping("/loadmore")
    public ResponseResult loadMore(@RequestBody ArticleHomeDto dto) {
        return apArticleService.load(ArticleConstants.LOADTYPE_LOAD_MORE,dto);
    }
    @Cacheable("articlesLoad")
    @PostMapping("/loadnew")
    public ResponseResult loadNew(@RequestBody ArticleHomeDto dto) {
        return apArticleService.load(ArticleConstants.LOADTYPE_LOAD_NEW,dto);
    }

    @GetMapping("/configurationTest") ResponseResult config() {
        System.out.println(articleConfiguration);
        return ResponseResult.okResult(articleConfiguration);
    }

    @PostMapping("/load_article_behavior")
    public  ResponseResult loadArticleBehavior(@RequestBody ArticleInfoDto dto ) {
        return null;
    }
}