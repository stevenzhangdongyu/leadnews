package com.heima.user.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.user.entity.dtos.UserRelationDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class ApUserFollowController {
    @PostMapping("/user_follow")
    public ResponseResult userFollow(@RequestBody UserRelationDto dto) {
        return null;
    }
}
