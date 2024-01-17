package com.heima.model.admin.pojos;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdRole implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 是否有效
     */
    private Integer isEnable;

    /**
     * 登录时间
     */
    private Date createdTime;


}
