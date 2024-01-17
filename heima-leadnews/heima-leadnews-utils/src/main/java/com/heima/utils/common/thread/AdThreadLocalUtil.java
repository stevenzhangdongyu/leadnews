package com.heima.utils.common.thread;

import com.heima.model.admin.pojos.AdUser;

public class AdThreadLocalUtil {
    private final static ThreadLocal<AdUser> AD_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 添加用户
     * @param adUser
     */
    public static void  setUser(AdUser adUser){
        AD_THREAD_LOCAL.set(adUser);
    }

    /**
     * 获取用户
     */
    public static AdUser getUser(){
        return AD_THREAD_LOCAL.get();
    }

    /**
     * 清理用户
     */
    public static void clear(){
        AD_THREAD_LOCAL.remove();
    }
}
