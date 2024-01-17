package com.heima.schedule;

import com.heima.common.redis.CacheService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ScheduleApplication.class)
class RedisTest {

    @Autowired
    private CacheService cacheService;
    @Test
    public void testList() {
//        cacheService.lLeftPush("list-001","helloWorld");
        System.out.println(cacheService.lRightPop("list-001"));
    }

    @Test
    public void testZset() {
        cacheService.zAdd("future_1","fuck_up_1",100);
        cacheService.zAdd("future_2","fuck_up_3",11111111);
        cacheService.zAdd("future_3","fuck_up_5",555);
        cacheService.zAdd("future_4","fuck_up_2",104440);
        cacheService.zAdd("future_5","shit_fucker",222);
//        Set<String> k1 = cacheService.zRangeByScore("k1", 0, 555);
//        System.out.println(k1);
    }

    @Test
    public void testKeys(){
        Set<String> keys = cacheService.keys("future_*");
        System.out.println(keys);

        Set<String> scan = cacheService.scan("future_*");
        System.out.println(scan);
    }
}