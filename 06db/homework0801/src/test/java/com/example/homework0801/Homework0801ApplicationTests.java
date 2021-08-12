package com.example.homework0801;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.homework0801.model.Order;
import com.example.homework0801.repository.OrderMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Homework0801ApplicationTests {

    @Autowired
    OrderMapper orderRepository;

    @Test
    public void writeTest() {
        for (int i = 0; i <= 1000; i++) {
            Order order = new Order();
            order.setUserId(Long.valueOf(i));
            order.setStatus("NORAMAL");
            int orderResult = orderRepository.insert(order);
            Assert.assertEquals(1, orderResult);
        }
    }



    @Test
    public void updateTest() {
        //此处已包含查询
        List<Order> orderList = orderRepository.selectList(new QueryWrapper<>());
        Order order = orderList.get(0);
        long now = System.currentTimeMillis();
        order.setStatus("updated");
        //不能更新用于分库的键
        order.setUserId(null);
        int result = orderRepository.updateById(order);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteTest() {
        int count = orderRepository.delete(new QueryWrapper<>());
        Assert.assertEquals(1001, count);

    }

    @Test
    public void xaTest() {
        for (int i = 0; i <= 5; i++) {
            Order order = new Order();
            order.setUserId(Long.valueOf(i));
            order.setStatus("xa");
            int orderResult = orderRepository.insert(order);
            Assert.assertEquals(1, orderResult);

            Order order2 = new Order();
            order2.setUserId(Long.valueOf(i));
            order2.setStatus("xa2");
            int orderResult2 = orderRepository.insert(order2);
            Assert.assertEquals(1, orderResult2);

        }
    }

}
