package com.devglan.service;

import com.devglan.model.User;

import java.util.List;

public interface UserService  {

    User add(User user);
    List<User> findAll();
    void delete(long id);
    User findByUsername(String username);
    User findById(Long id);
    User update(User user);
}
