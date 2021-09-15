package com.ecommerce.loginService.controller;

import com.ecommerce.loginService.entity.Address;
import com.ecommerce.loginService.service.AddressService;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/address/db")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/display")
    public String display(){
        return "Address Login Display";
    }

    @GetMapping("/{id}")
    public Address get(@PathVariable(name = "id") Long id){
        return addressService.get(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping
    public Address update(@RequestBody Address address){
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        addressService.delete(id);
    }

}
