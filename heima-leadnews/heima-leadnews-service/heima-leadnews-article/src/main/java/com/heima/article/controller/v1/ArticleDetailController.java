package com.heima.article.controller.v1;

import com.heima.article.entity.dto.CollectionBehaviorDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/detail")
public class ArticleDetailController {
    @PostMapping("/collection_behavior")
    public ResponseResult collectionBehavior(@RequestBody CollectionBehaviorDto dto) {
        return null;
    }
}
