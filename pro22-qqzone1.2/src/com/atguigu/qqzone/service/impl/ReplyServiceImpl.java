package com.atguigu.qqzone.service.impl;

import com.atguigu.qqzone.dao.ReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.HostReplyService;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.TopicService;
import com.atguigu.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @ClassNmae ReplyServiceImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/12 9:25
 * @Version 1.0
 **/
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO  replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            //1.给reply设置 author
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);

            //2.给reply设置主人回复
            HostReply hostReply = hostReplyService.getHostReplyByReplyID(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Reply reply) {
        HostReply hostReply = hostReplyService.getHostReplyByReplyID(reply.getId());
        if(hostReply != null){
            hostReplyService.delHostReply(hostReply);
        }
        replyDAO.delReply(reply);

//        //获取关联的所有回复reply
//        List<Reply> replyList = replyDAO.getReplyList(reply.getTopic());
//        if (replyList != null){
//            for (Reply topicReply : replyList) {
//                HostReply hostReply = hostReplyService.getHostReplyByReplyID(topicReply.getId());
//                if (hostReply != null){
//                    //删除主人回复
//                    hostReplyService.delHostReply(hostReply);
//                }
//                //删除无关联回复
//                replyDAO.delReply(reply);
//            }
//
//        }

    }

    @Override
    public Reply getReplyById(Integer id) {
        Reply reply = replyDAO.getReplyById(id);
        return reply;
    }
}
