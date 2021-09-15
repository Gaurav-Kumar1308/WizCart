package com.example.orderService.controller;


import com.example.orderService.dto.CartDto;
import com.example.orderService.entity.Cart;
import com.example.orderService.service.CartSerivce;
import com.example.orderService.service.OrderSerivce;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "order/cart/db")
public class CartController {

    @Autowired
    OrderSerivce orderSerivce;

    @Autowired
    CartSerivce cartService;

    @GetMapping("/display")
    public String display(){
        return "Cart Display";
    }

    @PostMapping
    public CartDto save(@RequestBody CartDto cartDto){
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDto,cart);
        cartService.save(cart);
        return cartDto;

    }

    @GetMapping(value = "/get/{id}")
    public CartDto get(@PathVariable(name = "id") Long id){

        CartDto cartDto = new CartDto();
        Cart cart = cartService.get(id);

        BeanUtils.copyProperties(cart,cartDto);
        return cartDto;



    }

    @PutMapping(value="/update")
    public CartDto update(@RequestBody CartDto cartDto){
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDto,cart);
        cartService.save(cart);
        return cartDto;

    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        cartService.delete(id);

    }

    @DeleteMapping(value="/deleteByUserId/{userId}")
    public void deleteByUserId(@PathVariable(name = "userId") long userId){
        cartService.deleteByUserId(userId);

    }

    @GetMapping(value="/findByUserId/{userId}")
    public List<Cart> findByUserId(@PathVariable(name = "userId") long userId){
        return cartService.findByUserId(userId);
    }

}
