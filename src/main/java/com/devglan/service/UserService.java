package com.devglan.service;

import com.devglan.model.user;

import java.util.List;

public interface UserService  {

    user add(user user);
    List<user> findAll();
    void delete(long id);
    user findByUsername(String username);
    user findById(Long id);
    user update(user user);
}
