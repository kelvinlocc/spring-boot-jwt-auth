package com.devglan.controller;

import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.User;
import com.devglan.model.UserToken;
import com.devglan.service.UserService;
import com.devglan.service.UserTokenService;
import com.devglan.untility.TimeUtil;
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

    @Autowired
    private UserTokenService userTokenService;

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        System.out.print("requesting /signup ");
        System.out.print(" User object" +user.toString());

        return userService.add(user);
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public UserToken logoutUser(@RequestBody User user){
        System.out.print("requesting /logout ");
        System.out.print(" User object" +user.toString());
        UserToken tokenInstance = userTokenService.findById(user.getId());
        tokenInstance.setTimeStamp(TimeUtil.getCurrentTimeStamp());
        tokenInstance.setToken(null);

        return userTokenService.update(tokenInstance);
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
