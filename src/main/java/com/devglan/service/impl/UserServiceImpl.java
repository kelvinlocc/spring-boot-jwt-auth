package com.devglan.service.impl;

import com.devglan.controller.exception.runtimeException.ServerInternalError;
import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.dao.UserDao;
import com.devglan.model.user;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserDao userDao;



    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        user user = userDao.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<user> findAll() {
        List<user> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public user findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public user findById(Long id) {
        return userDao.findOne(id);
    }


    @Override
    public user add(user user) {
        if (isDuplicated(user)) {
            throw new ServerInternalError("username is duplicated " + user.getUsername());
        }

        com.devglan.model.user newUser = new user();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setSalary(user.getSalary());
        newUser.setAge(user.getAge());
        return userDao.save(newUser);
    }

    @Override
    public user update(user user) {
        if (user.getUsername().isEmpty()) {
            throw new UserInputError("invalid username");
        }


        com.devglan.model.user userFromServer = findByUsername(user.getUsername());
        if (userFromServer == null) {
            throw new UserInputError("invalid username");
        }

        user.setId(userFromServer.getId());
        userFromServer.setUsername(user.getUsername());
        userFromServer.setPassword(bcryptEncoder.encode(user.getPassword()));
        userFromServer.setSalary(user.getSalary());
        userFromServer.setAge(user.getAge());

        return userDao.save(userFromServer);
    }

    private boolean isDuplicated(user user) {
        return findByUsername(user.getUsername()) != null;
    }
}
