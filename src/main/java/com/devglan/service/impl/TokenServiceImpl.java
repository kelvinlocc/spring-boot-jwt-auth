package com.devglan.service.impl;

import com.devglan.controller.exception.runtimeException.UserInputError;
import com.devglan.dao.TokenDao;
import com.devglan.dao.UserDao;
import com.devglan.model.UserToken;
import com.devglan.service.UserTokenService;
import com.devglan.untility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "tokenService")
public class TokenServiceImpl implements UserTokenService {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserDao userDao;


    @Override
    public UserToken add(UserToken userToken) {
        UserToken userDB = tokenDao.findByUserId(userToken.getUserId());
        if (userDB != null) {
            throw new UserInputError("user - token relation already established");
        }

        UserToken newUserToken = new UserToken();
        newUserToken.setTimeStamp(TimeUtil.getCurrentTimeStamp());
        newUserToken.setToken(userToken.getToken());
        newUserToken.setUserId(userToken.getUserId());
        return tokenDao.save(newUserToken);
    }

    @Override
    public void delete(long id) {
        tokenDao.delete(id);
    }


    @Override
    public UserToken findById(Long id) {
        return tokenDao.findOne(id);
    }

    // update token and timestamp
    @Override
    public UserToken update(UserToken userToken) {

        UserToken userDB = tokenDao.findByUserId(userToken.getUserId());
        if (userDB == null) {
            throw new UserInputError("user id is not found");
        }
        userDB.setToken(userToken.getToken());
        userDB.setTimeStamp(TimeUtil.getCurrentTimeStamp());
        return tokenDao.save(userDB);
    }


}
