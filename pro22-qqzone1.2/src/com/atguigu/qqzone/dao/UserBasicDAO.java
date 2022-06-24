package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.UserBasic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/5/8 17:09
 */
public interface UserBasicDAO {
    //根据账号密码获取特定用户信息
    public UserBasic getUserBasic(String loginId,String pwd);

    //获取指定用户的好友列表
    List<UserBasic> getUserBasicList(UserBasic userBasic);

    //根据id获取UserBasic对象
    UserBasic getUserBasicById(Integer id);

}
