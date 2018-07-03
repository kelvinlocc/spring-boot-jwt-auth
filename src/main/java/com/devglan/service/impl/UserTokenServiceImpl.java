package com.devglan.service.impl;

import com.devglan.controller.exception.runtimeException.GeneralError;
import com.devglan.dao.UserTokenDao;
import com.devglan.dao.UserDao;
import com.devglan.model.SqlEntity.UserToken;
import com.devglan.service.UserTokenService;
import com.devglan.untility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "userTokenService")
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    private UserTokenDao tokenDao;
    @Autowired
    private UserDao userDao;


    @Override
    public UserToken add(UserToken usertoken) {
        UserToken userDB = tokenDao.findByUserId(usertoken.getUserId());
        if (userDB != null) {
            throw new GeneralError("User - token relation already established");
        }

        UserToken newUsertoken = new UserToken();
        newUsertoken.setTimeStamp(TimeUtil.getCurrentTimeStamp());
        newUsertoken.setToken(usertoken.getToken());
        newUsertoken.setUserId(usertoken.getUserId());
        return tokenDao.save(newUsertoken);
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
    public UserToken update(UserToken usertoken) {

        UserToken userDB = tokenDao.findByUserId(usertoken.getUserId());
        if (userDB == null) {
            throw new GeneralError("User id is not found");
        }
        userDB.setToken(usertoken.getToken());
        userDB.setTimeStamp(TimeUtil.getCurrentTimeStamp());
        return tokenDao.save(userDB);
    }


}
