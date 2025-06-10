package org.example.ran.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ran.dao.OrderMapper;
import org.example.ran.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
    @Autowired
    OrderMapper orderMapper;

    public void createOrder(Long userId, Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setStatus("CREATED");
        orderMapper.insert(order);
    }

}
