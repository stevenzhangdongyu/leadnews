package com.heima.behavior.entity.dtos;

import com.heima.model.common.annotation.IdEncrypt;
import lombok.Data;

@Data
public class LikeBehaviorDto {
    @IdEncrypt
    private Long articleId;
    /**
     * 喜欢内容类型
     * 0文章
     * 1动态
     * 2评论
     */
    private Short operation;
    /**
     * 喜欢操作方式
     * 0 点赞
     * 1 取消点赞
     */
    private Short type;
}
