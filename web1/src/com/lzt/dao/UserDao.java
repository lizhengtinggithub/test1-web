package com.lzt.dao;

import com.lzt.pojo.User;

public interface UserDao {
    public User checkUserLoginDao(String name, String pwd);

}