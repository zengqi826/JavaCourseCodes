package com.example.homework0801.service;

import com.example.homework0801.model.Order;
import com.example.homework0801.repository.OrderMapper;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderServiceImpl
 *
 * @author zengqi
 * @date 2021/8/12 9:15
 */
@Service
public class OrderServiceImpl implements  OrderService{

    @Autowired
    OrderMapper orderMapper;
    @Override
    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void insert(Order order) {
        orderMapper.insert(order);
    }
}
