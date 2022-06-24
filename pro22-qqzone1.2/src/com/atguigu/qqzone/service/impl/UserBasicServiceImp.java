package com.atguigu.qqzone.service.impl;

import com.atguigu.qqzone.dao.UserBasicDAO;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNmae UserBasicServiceImp
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/10 15:49
 * @Version 1.0
 **/
public class UserBasicServiceImp implements UserBasicService {
    private UserBasicDAO userBasicDAO = null;
    @Override
    public UserBasic Login(String logId, String pwd) {
        UserBasic userBasic = userBasicDAO.getUserBasic(logId, pwd);
        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasicList.size());
        for (int i = 0; i < userBasicList.size(); i++) {
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return userBasicDAO.getUserBasicById(id);
    }
}
