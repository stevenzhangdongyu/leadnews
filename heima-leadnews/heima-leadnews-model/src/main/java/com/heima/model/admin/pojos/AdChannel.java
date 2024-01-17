package com.heima.model.admin.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ad_channel")
public class AdChannel implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableId(value = "id")
    private Integer id;

    private String name;
    private Integer ord;
    private Boolean status;
    private Boolean isDefault;
    private String description;
    private Date createdTime;
}
