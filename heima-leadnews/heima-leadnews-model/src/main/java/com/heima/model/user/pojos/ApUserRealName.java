package com.heima.model.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("ap_user_realname")
public class ApUserRealName {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private Integer userId;

    private String name;

    private String idno;
    private String fontImage;
    private String backImage;
    private String holdImage;
    private String liveImage;
    private Integer status;
    private String reason;
    private Date createdTime;
    private Date submitedTime;
    private Date updatedTime;
}
