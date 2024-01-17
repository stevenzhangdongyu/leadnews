package com.heima.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.heima.admin.mapper.AdUserMapper;
import com.heima.admin.service.AdUserService;
import com.heima.model.admin.dtos.AdUserDto;
import com.heima.model.admin.pojos.AdUser;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.utils.common.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AdUserServiceImpl implements AdUserService {
    @Autowired
    private AdUserMapper adUserMapper;
    @Override
    public ResponseResult login(AdUserDto dto) {
        if (dto == null || StringUtils.isBlank(dto.getName()) || StringUtils.isBlank(dto.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE);
        }
        HashMap<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name",dto.getName());
        stringStringHashMap.put("password",dto.getPassword());
        AdUser adUser = adUserMapper.selectOne(Wrappers.<AdUser>lambdaQuery().eq(AdUser::getName, dto.getName()));
        if (adUser == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST);
        }
        String salt = adUser.getSalt();
        String password = dto.getPassword();
        String psw = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        if (!psw.equals(adUser.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        String token = AppJwtUtil.getToken(adUser.getId().longValue());
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);
        adUser.setSalt("");
        adUser.setPassword("");
        map.put("user",adUser);
        return ResponseResult.okResult(map);
    }
}
