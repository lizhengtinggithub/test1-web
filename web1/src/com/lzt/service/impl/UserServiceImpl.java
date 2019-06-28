package com.lzt.service.impl;

import com.lzt.dao.UserDao;
import com.lzt.dao.impl.UserDaoImpl;
import com.lzt.pojo.User;
import com.lzt.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User checkUserLoginService(String name, String pwd) {
        UserDao userDao = new UserDaoImpl();

       User u = userDao.checkUserLoginDao(name,pwd);
        return u;
    }
}
