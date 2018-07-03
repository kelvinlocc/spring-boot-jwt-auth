package com.devglan.dao;

import com.devglan.model.SqlEntity.UserToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTokenDao extends CrudRepository<UserToken, Long> {
    UserToken findByUserId(Long userId);
}
