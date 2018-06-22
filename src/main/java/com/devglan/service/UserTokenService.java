package com.devglan.service;

import com.devglan.model.UserToken;

public interface UserTokenService {

    UserToken add(UserToken userToken);
    void delete(long id);
    UserToken findById(Long id);
    UserToken update(UserToken userToken);
}
