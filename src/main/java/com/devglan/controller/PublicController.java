package com.devglan.controller;

import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.LoginUser;
import com.devglan.model.user;
import com.devglan.model.UserToken;
import com.devglan.service.UserService;
import com.devglan.service.UserTokenService;
import com.devglan.untility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserTokenService userTokenService;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public user saveUser(@RequestBody user user) {
        System.out.print("requesting /signUp ");
        System.out.print(" user object" + user.toString());

        return userService.add(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public UserToken logoutUser(@RequestBody LoginUser user) {
        System.out.print("requesting /logout ");
        System.out.print(" user object" + user.toString());
        com.devglan.model.user userInstance = userService.findByUsername(user.getUsername());
        if (userInstance == null) {
            throw new UserInputError("invalid username");
        }
//        if (!userInstance.getPassword().equals(user.getPassword())) {
//            throw new UserInputError("invalid password");
//        }
        UserToken tokenInstance = userTokenService.findById(userInstance.getId());
        if (tokenInstance == null) {
            throw new UserInputError("internal error");
        }
        tokenInstance.setTimeStamp(TimeUtil.getCurrentTimeStamp());
        tokenInstance.setToken(null);

        return userTokenService.update(tokenInstance);
    }

    /**
     * temp
     **/
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public user updateUser(@RequestBody user user) {
        System.out.print("requesting /updateUser ");
        System.out.print(" user object" + user.toString());
        if (user.getUsername().isEmpty()) {
            throw new UserInputError("invalid username");
        }


        com.devglan.model.user userFromServer = userService.findByUsername(user.getUsername());
        if (userFromServer == null) {
            throw new UserInputError("invalid username");
        }

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );


        return userService.update(user);
    }
}
