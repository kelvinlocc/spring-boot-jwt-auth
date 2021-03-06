package com.devglan.controller;

import com.devglan.controller.exception.runtimeException.GeneralError;
import com.devglan.controller.misc.PublicApiController;
import com.devglan.model.InternalEntity.LoginUser;
import com.devglan.model.SqlEntity.User;
import com.devglan.model.SqlEntity.UserToken;
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
    public User saveUser(@RequestBody User user) {
        System.out.print("requesting /signUp ");
        System.out.print(" User object" + user.toString());

        return userService.add(user);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public UserToken logoutUser(@RequestBody LoginUser user) {
        System.out.print("requesting /logout ");
        System.out.print(" User object" + user.toString());
        User userInstance = userService.findByUsername(user.getUsername());
        if (userInstance == null) {
            throw new GeneralError("invalid username");
        }
//        if (!userInstance.getPassword().equals(User.getPassword())) {
//            throw new GeneralError("invalid password");
//        }
        UserToken tokenInstance = userTokenService.findById(userInstance.getId());
        if (tokenInstance == null) {
            throw new GeneralError("internal error");
        }
        tokenInstance.setTimeStamp(TimeUtil.getCurrentTimeStamp());
        tokenInstance.setToken(null);

        return userTokenService.update(tokenInstance);
    }

    /**
     * temp
     **/
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        System.out.print("requesting /updateUser ");
        System.out.print(" User object" + user.toString());
        if (user.getUsername().isEmpty()) {
            throw new GeneralError("invalid username");
        }
        User userFromServer = userService.findByUsername(user.getUsername());
        if (userFromServer == null) {
            throw new GeneralError("invalid username");
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
