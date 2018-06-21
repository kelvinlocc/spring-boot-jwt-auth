package com.devglan.service;

import com.devglan.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);
    User findById(Long id);
    User update(User user);
}
