package com.heima.admin;

import org.springframework.util.DigestUtils;

public class AdminTest {
    public static void main(String[] args) {
        String plainPassword = "admin";
        String salt = "123";
        String s = DigestUtils.md5DigestAsHex((plainPassword + salt).getBytes());
        System.out.println(s);
    }
}
