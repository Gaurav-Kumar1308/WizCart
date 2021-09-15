package com.example.orderService.service.impl;


import com.example.orderService.entity.OrderHistory;
import com.example.orderService.repository.OrderRepository;
import com.example.orderService.service.OrderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderSerivce {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderHistory get(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public OrderHistory save(OrderHistory order) {
        return orderRepository.save(order);
    }

    @Override
    public OrderHistory update(OrderHistory order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);

    }
}
