package com.example.orderService.controller;



import com.example.orderService.dto.OrderHistoryDto;
import com.example.orderService.dto.OrderRequestDTO;
import com.example.orderService.entity.Cart;
import com.example.orderService.entity.OrderHistory;
import com.example.orderService.service.CartSerivce;
import com.example.orderService.service.OrderSerivce;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "order/order/db")
public class OrderHistoryController {

    @Autowired
    OrderSerivce orderSerivce;

    @Autowired
    CartSerivce cartService;


    @GetMapping("/display")
    public String display(){
        return "Order Display";
    }

    @PostMapping(value="/create")
    public OrderHistoryDto save(@RequestBody OrderRequestDTO orderHistoryDto){

        List<Cart> cartList = cartService.findByUserId(orderHistoryDto.getUserId());
        for(Cart c: cartList){
            OrderHistory orderHistory = new OrderHistory();
            BeanUtils.copyProperties(c,orderHistory);
            orderHistory.setDateAndTime(orderHistoryDto.getDateAndTime());
            orderHistory.setUserAddress(orderHistoryDto.getUserAddress());

            OrderHistory savedOrderHistory = new OrderHistory();
            BeanUtils.copyProperties(orderHistory,savedOrderHistory);
            orderSerivce.save(savedOrderHistory);
        }
        cartService.deleteByUserId(orderHistoryDto.getUserId());
        return null;
    }

    @PutMapping(value="/update")
    public OrderHistoryDto update(@RequestBody OrderHistoryDto orderHistoryDto){
        OrderHistory orderHistory = new OrderHistory();
        BeanUtils.copyProperties(orderHistoryDto,orderHistory);
        orderSerivce.save(orderHistory);

        OrderHistoryDto savedOrderHistoryDto = new OrderHistoryDto();
        BeanUtils.copyProperties(orderHistory,savedOrderHistoryDto);

        return savedOrderHistoryDto;

    }

    @GetMapping(value = "/get/{id}")
    public OrderHistoryDto get(@PathVariable(name = "id") Long id){
        OrderHistory orderHistory = orderSerivce.get(id);
        OrderHistoryDto orderHistoryDto = new OrderHistoryDto();
        BeanUtils.copyProperties(orderHistory,orderHistoryDto);
        return orderHistoryDto;
    }


    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        orderSerivce.delete(id);

    }





}
