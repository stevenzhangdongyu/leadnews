package com.heima.model.admin.pojos;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单资源信息表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdMenu implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单代码
     */
    private String code;

    /**
     * 父菜单
     */
    private Integer parentId;

    /**
     * 登录时间
     */
    private Date createdTime;


}
