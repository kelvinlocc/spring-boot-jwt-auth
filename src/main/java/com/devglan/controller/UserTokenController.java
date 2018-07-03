package com.devglan.controller;

import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.UserToken;
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

//    @RequestMapping(value="/user", method = RequestMethod.GET)
//    public List<user> listUser(){
//        return userTokenService.findAll();
//    }
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//    public user getOne(@PathVariable(value = "id") Long id){
//        return userTokenService.findById(id);
//    }

    @RequestMapping(value="/addToken", method = RequestMethod.POST)
    public UserToken saveUser(@RequestBody UserToken userToken){

        System.out.print("requesting /addToken ");
        System.out.print(" user object" +userToken.toString());

        return this.userTokenService.add(userToken);
    }









}
