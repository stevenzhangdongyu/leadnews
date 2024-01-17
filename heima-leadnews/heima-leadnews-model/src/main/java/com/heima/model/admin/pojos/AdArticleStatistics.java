package com.heima.model.admin.pojos;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章数据统计表
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdArticleStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
      private Integer id;

    /**
     * 主账号ID
     */
    private Integer articleWeMedia;

    /**
     * 子账号ID
     */
    private Integer articleCrawlers;

    /**
     * 频道ID
     */
    private Integer channelId;

    /**
     * 草读量
     */
    private Integer read20;

    /**
     * 读完量
     */
    private Integer read100;

    /**
     * 阅读量
     */
    private Integer readCount;

    /**
     * 评论量
     */
    private Integer comment;

    /**
     * 关注量
     */
    private Integer follow;

    /**
     * 收藏量
     */
    private Integer collection;

    /**
     * 转发量
     */
    private Integer forward;

    /**
     * 点赞量
     */
    private Integer likes;

    /**
     * 不喜欢
     */
    private Integer unlikes;

    /**
     * unfollow
     */
    private Integer unfollow;

    /**
     * 创建时间
     */
    private Date createdTime;


}
