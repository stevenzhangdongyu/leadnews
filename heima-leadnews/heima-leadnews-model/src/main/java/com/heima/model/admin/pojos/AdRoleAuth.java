package com.heima.model.admin.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色权限信息表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdRoleAuth implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 资源类型	            0 菜单	            1 功能
     */
    private Integer type;

    /**
     * 资源ID
     */
    private Integer entryId;

    /**
     * 登录时间
     */
    private Date createdTime;


}
