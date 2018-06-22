package com.devglan.dao;

import com.devglan.model.UserToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenDao extends CrudRepository<UserToken, Long> {
    UserToken findByUserId(Long userId);
}
