package com.heima.article.entity.dto;

import com.heima.model.common.annotation.IdEncrypt;
import lombok.Data;

@Data
public class ArticleInfoDto {
    @IdEncrypt
    private Long articleId;
    private Integer authorId;
}
