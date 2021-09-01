package com.zengqi.week11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Week11ApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private StockController stockController;
    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("product1_stock","1000");
        stockController.reduceInventory("product1");
    }

}
