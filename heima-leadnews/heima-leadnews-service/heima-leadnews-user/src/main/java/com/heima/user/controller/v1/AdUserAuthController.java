package com.heima.user.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthListDto;
import com.heima.user.service.ApUserRealNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AdUserAuthController {
    @Autowired
    private ApUserRealNameService apUserRealNameService;
    @PostMapping("/list")
    public ResponseResult authList(@RequestBody AuthListDto dto) {
        return apUserRealNameService.authList(dto);
    }

    @PostMapping("/authPass")
    public ResponseResult authPass(@RequestBody AuthListDto dto) {
        return apUserRealNameService.authPass(dto);
    }
    @PostMapping("/authFail")
    public ResponseResult authFail(@RequestBody AuthListDto dto) {
        return apUserRealNameService.authFail(dto);
    }
}
