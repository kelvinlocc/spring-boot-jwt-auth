package com.devglan.controller;

import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.User;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ccloa on 21/6/2018.
 */
@PublicApiController
public class PublicController {
    @Autowired
    private UserService userService;


    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        System.out.print("requesting /signup ");
        System.out.print(" User object" +user.toString());

        return userService.add(user);
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public User logoutUser(@RequestBody User user){
        System.out.print("requesting /logout "); 8473
        System.out.print(" User object" +user.toString());

        return userService.add(user);
    }

    /**
     *      temp
     *  **/
    @RequestMapping(value="/updateUser", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user){
        System.out.print("requesting /updateUser ");
        System.out.print(" User object" +user.toString());

        return userService.update(user);
    }
}
