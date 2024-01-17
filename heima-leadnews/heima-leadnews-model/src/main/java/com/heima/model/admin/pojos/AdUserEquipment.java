package com.heima.model.admin.pojos;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 管理员设备信息表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdUserEquipment implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 0PC	            1ANDROID	            2IOS	            3PAD	            9 其他
     */
    private Integer type;

    /**
     * 设备版本
     */
    private String version;

    /**
     * 设备系统
     */
    private String sys;

    /**
     * 设备唯一号，MD5加密
     */
    private String no;

    /**
     * 登录时间
     */
    private Date createdTime;


}
