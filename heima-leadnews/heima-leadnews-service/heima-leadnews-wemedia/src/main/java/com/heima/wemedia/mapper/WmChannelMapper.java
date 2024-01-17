package com.heima.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.wemedia.pojos.WmChannel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WmChannelMapper extends BaseMapper<WmChannel> {

    List<WmChannel> getChannelList(@Param("offset") Integer offset,@Param("size") Integer size,@Param("name") String name);
}