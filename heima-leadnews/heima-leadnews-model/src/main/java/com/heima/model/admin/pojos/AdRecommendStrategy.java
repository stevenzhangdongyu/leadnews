package com.heima.model.admin.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 推荐策略信息表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdRecommendStrategy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
      private Integer id;

    /**
     * 策略名称
     */
    private String name;

    /**
     * 策略描述
     */
    private String description;

    /**
     * 是否有效
     */
    private Boolean isEnable;

    /**
     * 分组ID
     */
    private Integer groupId;

    /**
     * 创建时间
     */
    private Date createdTime;


}
