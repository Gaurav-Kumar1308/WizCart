package com.ecommerce.loginService.service;

import com.ecommerce.loginService.entity.User;

import java.util.List;

public interface UserService {
    public User get(Long id);
    public User save(User user);
    public User update(User user);
    public void delete(Long id);
    public User findByEmailAndPassword(String email, String password);
    public List<User> findByEmail(String email);
}
