package com.devglan.service.validation;

import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.dao.UserDao;
import com.devglan.model.LoginUser;
import com.devglan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by ccloa on 21/6/2018.
 */
@Component
public class ValidateUser {
    private static final ValidateUser inst = new ValidateUser();

    private ValidateUser() {
    }

    @Bean
    public static ValidateUser getInstance() {
        return inst;
    }

    @Autowired
    private UserDao userDao;

    public boolean isLoginUserValid(LoginUser userInput) {
        User byUsername = userDao.findByUsername(userInput.getUsername());
        if (byUsername == null) {
            System.out.print("invalid username");
            return false;

        }

        if (!Objects.equals(byUsername.getPassword(), userInput.getPassword())) {
            System.out.print("invalid password");
            return false;

        }

        return true;
    }

    public boolean isUsernameExist(LoginUser userInput) {
        if (userInput == null) {
            return false;
        }
        User byUsername = userDao.findByUsername(userInput.getUsername());
        if (byUsername == null) {
            return false;
        }
        return true;


    }

    public boolean isPasswordMatch(LoginUser userInput) {
        User byUsername = userDao.findByUsername(userInput.getUsername());
        if (Objects.equals(byUsername.getPassword(), userInput.getPassword())) {
            return true;

        }

        return false;

    }


}
