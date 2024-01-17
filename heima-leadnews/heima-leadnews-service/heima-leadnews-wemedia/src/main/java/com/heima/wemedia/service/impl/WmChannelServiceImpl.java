package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.apis.article.IArticleClient;
import com.heima.common.constants.WmNewsMessageConstants;
import com.heima.model.admin.dtos.ListChannelDto;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.pojos.WmChannel;
import com.heima.wemedia.mapper.WmChannelMapper;
import com.heima.wemedia.service.WmChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class WmChannelServiceImpl extends ServiceImpl<WmChannelMapper, WmChannel> implements WmChannelService {

    @Autowired
    private IArticleClient iArticleClient;
    @Autowired
    private WmChannelMapper wmChannelMapper;
    /**
     * 查询所有频道
     * @return
     */
    @Override
    public ResponseResult findAll() {
        return ResponseResult.okResult(list());
    }

    @Override
    public ResponseResult listChannels(ListChannelDto dto) {
        /**
         * TODO
         * 权限审查
         */
//        AdUser adUser = AdThreadLocalUtil.getUser();
//        if (adUser == null) {
//            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
//        }
//        Integer adUserId = adUser.getId();
//        if (adUserId == null) {
//            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
//        }
//        AdUser adUserSearched = adUserMapper.selectOne(Wrappers.<AdUser>lambdaQuery().eq(AdUser::getId, adUserId));
//        if (adUserSearched == null) {
//            return ResponseResult.errorResult(AppHttpCodeEnum.NEED_ADMIND);
//        }
        dto.checkParam();
        try {
            List<WmChannel> channelList = wmChannelMapper.getChannelList((dto.getPage() - 1) * dto.getSize(), dto.getSize(), dto.getName());
            return ResponseResult.okResult(channelList);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }


    }

    @Override
    public ResponseResult deleteChannelById(Integer id) {
        WmChannel wmChannel = wmChannelMapper.selectOne(Wrappers.<WmChannel>lambdaQuery().eq(WmChannel::getId, id));
        if (wmChannel == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        String name = wmChannel.getName();
        ResponseResult responseResult = iArticleClient.findChannel(name);
        if (responseResult.getErrorMessage().equals(WmNewsMessageConstants.WM_CHANNEL_IS_REFERRED)) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"这个频道已经被引用，不能删除");
        }
        wmChannelMapper.delete(Wrappers.<WmChannel>lambdaQuery().eq(WmChannel::getId, id));
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Override
    public ResponseResult saveChannel(WmChannel dto) {
        if (dto == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        String name = dto.getName();
        WmChannel wmChannel = wmChannelMapper.selectOne(Wrappers.<WmChannel>lambdaQuery().eq(WmChannel::getName, name));
        if (wmChannel != null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST);
        }
        if (dto.getCreatedTime() == null) {
            dto.setCreatedTime(new Date());
        }
        if (dto.getIsDefault() == null) {
            dto.setIsDefault(true);
        }
        wmChannelMapper.insert(dto);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    @Async
    @Override
    public ResponseResult updateChannel(WmChannel dto) {
        if (dto == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        if (dto.getId() == null ) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        WmChannel datasetWmChannel = getById(dto.getId());
        if (datasetWmChannel == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        if (dto.getStatus() == false) {
            //1，检查所有文章列表，查看是否有还在上架的文章，如果有，则拒绝操作
            //1.1kafka不行，因为是异步调用，并且还有一个中间件挡住，所以还是用feign吧
            //1.2 feign
            ResponseResult responseResult = iArticleClient.findChannel(dto.getName());
            if (responseResult.getErrorMessage().equals(WmNewsMessageConstants.WM_CHANNEL_IS_REFERRED)) {
                return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"这个频道已经被引用，不能禁用");
            }
        }
        wmChannelMapper.updateById(dto);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


}