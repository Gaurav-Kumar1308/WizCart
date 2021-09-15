package com.example.orderService.repository;


import com.example.orderService.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

    public void deleteByUserId(long userId);
    public List<Cart> findByUserId(long userId);
}
