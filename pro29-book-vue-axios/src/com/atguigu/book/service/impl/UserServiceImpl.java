package com.atguigu.book.service.impl;

import com.atguigu.book.dao.UserDAO;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.UserService;

/**
 * @ClassNmae UserImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/16 0:37
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);

    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User ckGetUser(User user) {
        return userDAO.ckGetUser(user);
    }
}
