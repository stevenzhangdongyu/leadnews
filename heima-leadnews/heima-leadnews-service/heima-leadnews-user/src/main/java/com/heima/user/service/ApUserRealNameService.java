package com.heima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthListDto;
import com.heima.model.user.pojos.ApUserRealName;

public interface ApUserRealNameService extends IService<ApUserRealName> {

    public ResponseResult authList(AuthListDto dto);

    public ResponseResult authPass(AuthListDto dto);

    public ResponseResult authFail(AuthListDto dto);
}
