package com.heima.admin.controller.v1;


import com.heima.admin.service.AdUserService;
import com.heima.model.admin.dtos.AdUserDto;
import com.heima.model.common.dtos.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AdUserLoginController {
    @Autowired
    private AdUserService adUserService;
    @PostMapping("/login/in")
    public ResponseResult adUserLogin(@RequestBody AdUserDto dto) {
        return adUserService.login(dto);
    }
}
