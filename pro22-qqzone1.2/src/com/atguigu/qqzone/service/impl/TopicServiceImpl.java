package com.atguigu.qqzone.service.impl;

import com.atguigu.qqzone.dao.ReplyDAO;
import com.atguigu.qqzone.dao.TopicDAO;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;
import com.atguigu.qqzone.service.ReplyService;
import com.atguigu.qqzone.service.TopicService;
import com.atguigu.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @ClassNmae TopicServiceImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/10 16:52
 * @Version 1.0
 **/
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO;
    private ReplyService replyService;
    private UserBasicService userBasicService;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        List<Topic> topicList = topicDAO.getTopicList(userBasic);
        return topicList;
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);
        return topic;
    }

    @Override
    public Topic getTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;
    }

    @Override
    public void delTopic(Topic topic) {
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        if (replyList != null){
            for (Reply reply : replyList) {
                replyService.delReply(reply);
            }
        topicDAO.delTopic(topic);
        }

    }

    @Override
    public void addTopic(Topic topic) {
        topicDAO.addTopic(topic);
    }
}
