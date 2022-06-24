package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassNmae UserBasicService
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/10 15:43
 * @Version 1.0
 **/
public interface UserBasicService {
    //用户登录方法
    UserBasic Login(String logId,String pwd);

    //获取好友
    List<UserBasic> getFriendList(UserBasic userBasic);

    //根据id获取指定好友
    UserBasic getUserBasicById(Integer id);



}
