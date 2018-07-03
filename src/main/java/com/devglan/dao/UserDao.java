package com.devglan.dao;

import com.devglan.model.user;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<user, Long> {
    user findByUsername(String username);
}
