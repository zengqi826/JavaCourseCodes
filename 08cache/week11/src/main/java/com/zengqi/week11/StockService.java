package com.zengqi.week11;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * StockService
 * 参考RedissionDemo
 * @author zengqi
 * @date 2021/9/1 9:46
 */
@Service
public class StockService {

    @Autowired
    private Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void reduceStock(String productId, int num) {
        String lockKey = productId + "_lock";
        RLock redissonLock = redisson.getLock(lockKey);
        try {
            redissonLock.lock(30, TimeUnit.SECONDS);
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get(productId + "_stock"));
            if (stock - num >= 0) {
                int nextStock = stock - num;
                this.stringRedisTemplate.opsForValue().set(productId + "_stock", nextStock + "");
                System.out.println("库存扣减成功，剩余库存为" + nextStock);
            } else {
                System.out.println("库存扣减失败，库存不足");
            }
        } finally {
            redissonLock.unlock();
        }
    }
}
