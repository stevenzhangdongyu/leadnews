package com.heima.redis;

import com.heima.common.redis.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RedisDemoApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void redisTest_save_data() {
        System.out.println(cacheService.hGet("user-session:123", "surname"));
        cacheService.hPut("articleLikes","1","123");
    }
}
