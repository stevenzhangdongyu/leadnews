package com.heima.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.common.constants.UserAuthConstants;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.AuthListDto;
import com.heima.model.user.pojos.ApUserRealName;
import com.heima.user.mapper.ApUserRealNameMapper;
import com.heima.user.service.ApUserRealNameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ApUserRealNameServiceImpl extends ServiceImpl<ApUserRealNameMapper, ApUserRealName> implements ApUserRealNameService {
    @Autowired
    ApUserRealNameMapper apUserRealNameMapper;


    @Override
    public ResponseResult authList(AuthListDto dto) {
        Integer page = dto.getPage();
        Integer size = dto.getSize();
//        Integer count = wmMaterialMapper.getRecordsCount(apUserId,type);

        List<ApUserRealName> list = list();
        Integer count = list.size();
        List<ApUserRealName> apUserRealNames = list.subList((page - 1) * size, Math.min(count, page * size));
        ResponseResult responseResult = new PageResponseResult(page,size,count);
        responseResult.setData(apUserRealNames);
        return responseResult;
    }

    @Override
    public ResponseResult authPass(AuthListDto dto) {
        if (dto == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Integer id = dto.getId();
        if (id == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        ApUserRealName apUserRealName = apUserRealNameMapper.selectOne(Wrappers.<ApUserRealName>lambdaQuery().eq(ApUserRealName::getId, id));
        if (apUserRealName == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        if (apUserRealName.getStatus() == UserAuthConstants.WAITING_AUTH) {
            apUserRealName.setStatus(UserAuthConstants.AUTH_SUCCESS);
            apUserRealName.setReason(dto.getMsg());
            saveOrUpdate(apUserRealName);

            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS.getCode());
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
    }

    @Override
    public ResponseResult authFail(AuthListDto dto) {
        if (dto == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        Integer id = dto.getId();
        if (id == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        ApUserRealName apUserRealName = apUserRealNameMapper.selectOne(Wrappers.<ApUserRealName>lambdaQuery().eq(ApUserRealName::getId, id));
        if (apUserRealName == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        if (apUserRealName.getStatus() == UserAuthConstants.WAITING_AUTH) {
            apUserRealName.setStatus(UserAuthConstants.AUTH_FAIL);
            apUserRealName.setReason(dto.getMsg());
            saveOrUpdate(apUserRealName);

            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS.getCode());
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
    }
}
