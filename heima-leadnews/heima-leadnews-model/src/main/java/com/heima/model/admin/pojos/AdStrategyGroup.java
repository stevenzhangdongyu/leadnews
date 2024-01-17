package com.heima.model.admin.pojos;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 推荐策略分组信息表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdStrategyGroup implements Serializable {

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
     * 创建时间
     */
    private Date createdTime;


}
