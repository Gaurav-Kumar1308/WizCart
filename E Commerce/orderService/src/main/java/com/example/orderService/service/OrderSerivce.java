package com.example.orderService.service;




import com.example.orderService.entity.OrderHistory;

public interface OrderSerivce {

    public OrderHistory get(Long id);
    public OrderHistory save(OrderHistory employee);
    public OrderHistory update(OrderHistory employee);
    public void delete(Long id);
}
