package com.heima.behavior.entity.dtos;

import com.heima.model.common.annotation.IdEncrypt;
import lombok.Data;

@Data
public class UnLikesBehaviorDto {
    @IdEncrypt
    private Long articleId;
    private Short type;
}
