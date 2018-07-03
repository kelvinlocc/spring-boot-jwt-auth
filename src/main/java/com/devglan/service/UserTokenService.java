package com.devglan.service;

import com.devglan.model.SqlEntity.UserToken;

public interface UserTokenService {

    UserToken add(UserToken usertoken);
    void delete(long id);
    UserToken findById(Long id);
    UserToken update(UserToken usertoken);
}
