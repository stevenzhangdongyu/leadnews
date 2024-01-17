package com.heima.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.wemedia.pojos.WmMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WmMaterialMapper extends BaseMapper<WmMaterial> {

    public List<WmMaterial> getPictureList(@Param("offset") Integer offset,@Param("size") Integer size,@Param("collection")
        short collection,@Param("apUserId") Integer apUserId);

    public Integer getRecordsCount(@Param("apUserId") Integer apUserId ,@Param("collection") short collection);
}