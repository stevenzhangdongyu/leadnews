package com.heima.model.admin.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 管理员操作行为信息表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdUserOpertion implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 登录设备ID
     */
    private Integer equipmentId;

    /**
     * 登录IP
     */
    private String ip;

    /**
     * 登录地址
     */
    private String address;

    /**
     * 操作类型
     */
    private Integer type;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 登录时间
     */
    private Date createdTime;


}
