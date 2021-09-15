package com.ecommerce.loginService.controller;

import com.ecommerce.loginService.dto.LoginDTO;
import com.ecommerce.loginService.dto.LoginResponseDTO;
import com.ecommerce.loginService.entity.User;
import com.ecommerce.loginService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;


@RestController
@RequestMapping("auth/merchant/db")

public class MerchantController {

    @Autowired
    private UserService userService;

    @GetMapping("/display")
    public String display(){
        return "Merchant Login Display";
    }

    @GetMapping("/{id}")
    public User get(@PathVariable(name = "id") Long id){
        return userService.get(id);
    }

    @PostMapping
    public User save(@RequestBody User user){
        user.setMerchant(true);
        return userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        userService.delete(id);
    }

    @PostMapping("/validate")
    public LoginResponseDTO validateMerchant(@RequestBody LoginDTO loginDTO){
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        User user = userService.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if(user!=null && user.getMerchant()){
            loginResponseDTO.setStatus(true);
            loginResponseDTO.setId(user.getId());
        }
        else{
            loginResponseDTO.setStatus(false);
            loginResponseDTO.setId(-1);
        }
        return loginResponseDTO;
    }

}
