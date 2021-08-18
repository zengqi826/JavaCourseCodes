package io.kimmking.dubbo.demo.api.service;

import io.kimmking.dubbo.demo.api.entity.Order;

public interface OrderService {

    Order findOrderById(int id);

}
