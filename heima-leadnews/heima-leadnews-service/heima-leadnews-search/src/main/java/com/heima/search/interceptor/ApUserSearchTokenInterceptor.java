package com.heima.search.interceptor;

import com.heima.model.user.pojos.ApUser;
import com.heima.utils.common.thread.ApUserSearchThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
public class ApUserSearchTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader("userId");
        Optional<String> optional = Optional.ofNullable(userId);
        if (optional.isPresent()){
            ApUser apUser  = new ApUser();
            apUser.setId(Integer.valueOf(userId));
            ApUserSearchThreadLocalUtil.setUser(apUser);
            log.info("apUserSearchTokenFilter设置用户信息到threadlocal中...");
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
