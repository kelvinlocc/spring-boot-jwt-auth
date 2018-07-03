package com.devglan.controller;

import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.SqlEntity.UserToken;
import com.devglan.service.UserService;
import com.devglan.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@PublicApiController
public class UserTokenController {

    @Autowired
    private UserTokenService userTokenService;

    @Autowired
    private UserService userService;

//    @RequestMapping(value="/User", method = RequestMethod.GET)
//    public List<User> listUser(){
//        return userTokenService.findAll();
//    }
//
//    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET)
//    public User getOne(@PathVariable(value = "id") Long id){
//        return userTokenService.findById(id);
//    }

    @RequestMapping(value="/addToken", method = RequestMethod.POST)
    public UserToken saveUser(@RequestBody UserToken usertoken){

        System.out.print("requesting /addToken ");
        System.out.print(" User object" + usertoken.toString());

        return this.userTokenService.add(usertoken);
    }









}
