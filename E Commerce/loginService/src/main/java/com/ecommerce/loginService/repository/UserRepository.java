package com.ecommerce.loginService.repository;

import com.ecommerce.loginService.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmailAndPassword(String email, String password);
    List<User> findByEmail(String email);
}
