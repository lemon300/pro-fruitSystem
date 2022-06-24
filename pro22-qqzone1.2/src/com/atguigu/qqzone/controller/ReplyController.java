package com.atguigu.qqzone.controller;

import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.HostReplyService;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ClassNmae ReplyController
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/13 9:33
 * @Version 1.0
 **/
public class ReplyController {
    private ReplyService replyService;
    private HostReplyService hostReplyService;
    private TopicService topicService;
    public String addReply(String content,Integer topicId, HttpSession session){
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply(content,new Date(),author,new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }
    public String delReply(Integer replyId,Integer topicId){
        Reply reply= replyService.getReplyById(replyId);
        replyService.delReply(reply);
        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }
    public String addHostReply(Integer replyId,String hostReplyContent,Integer topicId,HttpSession session){
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Reply reply = replyService.getReplyById(replyId);
        HostReply hostReply = new HostReply(hostReplyContent,new Date(),author,reply);
        hostReplyService.addHostReply(hostReply);
        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }
}
