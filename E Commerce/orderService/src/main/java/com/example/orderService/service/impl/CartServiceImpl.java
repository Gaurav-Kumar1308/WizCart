package com.example.orderService.service.impl;


import com.example.orderService.entity.Cart;
import com.example.orderService.repository.CartRepository;
import com.example.orderService.service.CartSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

class CartServiceImpl implements CartSerivce {

    @Autowired
    CartRepository cartRepository;


    @Override
    public Cart get(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);

    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void deleteByUserId(long id) {
        cartRepository.deleteByUserId(id);
    }

    public List<Cart> findByUserId(long userId){
        return cartRepository.findByUserId(userId);
    }
}
