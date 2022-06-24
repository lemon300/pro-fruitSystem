package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.HostReplyService;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @ClassNmae TopicController
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/12 8:19
 * @Version 1.0
 **/
public class TopicController {
    private TopicService topicService = null;
    private ReplyService replyService = null;
    private HostReplyService hostReplyService = null;

    public String topicDetail(Integer id, HttpSession session){
        Topic topic = topicService.getTopicById(id);
        session.setAttribute("topic",topic);
        return "frames/detail";
    }
    public String delTopic(Integer topicId){
        Topic topic = topicService.getTopic(topicId);
        topicService.delTopic(topic);
        return "redirect:topic.do?operate=getTopicList";
    }
    public String getTopicList(HttpSession session){
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);
        session.setAttribute("friend",userBasic);
        return "frames/main";

    }
    public String addTopic(String topicTitle,String topicContent,HttpSession session){
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Topic topic = new Topic(topicTitle,topicContent,new Date(),author);
        topicService.addTopic(topic);
        return "redirect:topic.do?operate=getTopicList";
    }
}
