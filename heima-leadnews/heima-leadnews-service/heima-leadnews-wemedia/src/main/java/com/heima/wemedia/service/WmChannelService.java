package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.admin.dtos.ListChannelDto;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.pojos.WmChannel;

public interface WmChannelService extends IService<WmChannel> {

    /**
     * 查询所有频道
     * @return
     */
    public ResponseResult findAll();

    public ResponseResult listChannels( ListChannelDto dto) ;

    public ResponseResult deleteChannelById(Integer id);

    public ResponseResult saveChannel(WmChannel dto);

    public ResponseResult updateChannel( WmChannel dto);
}