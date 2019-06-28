package com.lzt.test;

import com.lzt.pojo.User;
import com.lzt.service.impl.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
         User u = userService.checkUserLoginService("张三","123");
        System.out.println(u);

    }
}
