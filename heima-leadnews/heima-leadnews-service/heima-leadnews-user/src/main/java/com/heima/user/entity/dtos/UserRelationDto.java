package com.heima.user.entity.dtos;

import com.heima.model.common.annotation.IdEncrypt;
import lombok.Data;

@Data
public class UserRelationDto {
    @IdEncrypt
    private Long articleId;
    private Integer authorId;
    /**
     * 0  关注   1  取消
     */
    private Short operation;
}
