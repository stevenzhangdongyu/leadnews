package com.heima.admin.service;

import com.heima.model.admin.dtos.AdUserDto;
import com.heima.model.common.dtos.ResponseResult;

public interface AdUserService {
    public ResponseResult login(AdUserDto dto);
}
