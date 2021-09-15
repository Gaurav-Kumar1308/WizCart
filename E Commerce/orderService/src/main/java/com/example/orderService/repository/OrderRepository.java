package com.example.orderService.repository;


import com.example.orderService.entity.OrderHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderHistory,Long> {


}

