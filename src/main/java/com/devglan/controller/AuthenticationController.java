package com.devglan.controller;

import com.devglan.config.JwtTokenUtil;
import com.devglan.model.AuthToken;
import com.devglan.model.LoginUser;
import com.devglan.model.User;
import com.devglan.model.UserToken;
import com.devglan.service.UserService;
import com.devglan.service.UserTokenService;
import com.devglan.untility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTokenService userTokenService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findByUsername(loginUser.getUsername());

        final String token = jwtTokenUtil.generateToken(user);
        updateUserToken(user.getId(), token);
        return ResponseEntity.ok(new AuthToken(token));
    }

    private void updateUserToken(Long userId, String token) {
        System.out.println("updateUserToken for userId: " + userId);

        UserToken tokenInstance = userTokenService.findById(userId);
        if (tokenInstance == null) {
            System.out.println("create new token: ");
            tokenInstance = new UserToken();
            tokenInstance.setUserId(userId);
            tokenInstance.setToken(token);
            tokenInstance.setTimeStamp(TimeUtil.getCurrentTimeStamp());
            userTokenService.add(tokenInstance);
        } else {
            System.out.println("update token: ");
            System.out.println("old token is created at " + tokenInstance.getTimeStamp());
            System.out.println("old token is " + tokenInstance.getToken());
            tokenInstance.setToken(token);
            tokenInstance.setTimeStamp(TimeUtil.getCurrentTimeStamp());
            userTokenService.update(tokenInstance);
        }



        // debug:
        tokenInstance = userTokenService.findById(userId);
        System.out.println("new token is created at " + tokenInstance.getTimeStamp());
        System.out.println("new token is " + tokenInstance.getToken());

    }

}
