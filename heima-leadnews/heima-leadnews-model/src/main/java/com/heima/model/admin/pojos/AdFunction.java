package com.heima.model.admin.pojos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 页面功能信息表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdFunction implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    /**
     * 功能名称
     */
    private String name;

    /**
     * 功能代码
     */
    private String code;

    /**
     * 父功能
     */
    private Integer parentId;

    /**
     * 登录时间
     */
    private Date createdTime;


}
