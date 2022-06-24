package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.TopicService;
import com.atguigu.qqzone.service.UserBasicService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassNmae UserController
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/10 18:49
 * @Version 1.0
 **/
public class UserController {
    private UserBasicService userBasicService = null;
    private TopicService topicService = null;
    public String login(String loginId, String pwd, HttpSession session){
        //1.登录验证
        UserBasic userBasic = userBasicService.Login(loginId, pwd);
        if(userBasic != null){
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            session.setAttribute("userBasic",userBasic);
            session.setAttribute("friend",userBasic);
            return "index";
        }
        return "login";
    }
    public String friend(Integer id,HttpSession session){
        UserBasic currFriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currFriend);
        currFriend.setTopicList(topicList);
        session.setAttribute("friend",currFriend);
        return "index";
    }
}
