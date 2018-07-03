package com.devglan.controller;

import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.user;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PublicApiController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<user> listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public user getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

}
