package com.heima.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.admin.pojos.AdUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 管理员用户信息表 Mapper 接口
 * </p>
 *
 * @author zdy
 * @since 2024-01-14
 */
@Mapper
public interface AdUserMapper extends BaseMapper<AdUser> {

}
