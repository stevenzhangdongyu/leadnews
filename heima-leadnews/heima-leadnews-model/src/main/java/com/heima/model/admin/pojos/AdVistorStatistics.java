package com.heima.model.admin.pojos;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 访问数据统计表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdVistorStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
      private Integer id;

    /**
     * 日活
     */
    private Integer activity;

    /**
     * 访问量
     */
    private Integer vistor;

    /**
     * IP量
     */
    private Integer ip;

    /**
     * 注册量
     */
    private Integer register;

    /**
     * 创建时间
     */
    private Date createdTime;


}
