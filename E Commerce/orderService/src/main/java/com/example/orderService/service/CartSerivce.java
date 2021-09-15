package com.example.orderService.service;


import com.example.orderService.entity.Cart;

import java.util.List;

public interface CartSerivce {

    public Cart get(Long id);
    public Cart save(Cart cart);
    public Cart update(Cart cart);
    public void delete(Long id);
    public void deleteByUserId(long id);
    public List<Cart> findByUserId(long userId);



}
