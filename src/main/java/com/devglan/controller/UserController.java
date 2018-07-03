package com.devglan.controller;

import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.SqlEntity.User;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PublicApiController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/User", method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

}
