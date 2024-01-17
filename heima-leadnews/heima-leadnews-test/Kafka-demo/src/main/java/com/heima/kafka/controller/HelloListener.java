package com.heima.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class HelloListener {

    @KafkaListener(topics = "user-topic")
    public void onMessage(String message){
        if(!StringUtils.isEmpty(message)){
            JSONObject jsonObject = JSON.parseObject(message);
            System.out.println(jsonObject.getString("username"));
            System.out.println(jsonObject);
            Object object = JSON.parse(message);
            System.out.println(object);
        }

    }
}