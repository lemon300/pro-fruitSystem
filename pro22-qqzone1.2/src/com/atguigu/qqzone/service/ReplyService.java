package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Reply;

import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/5/12 9:16
 */
public interface ReplyService {
    //根据topic的id 获取关联的所有回复
    List<Reply> getReplyListByTopicId(Integer topicId);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReply(Reply reply);
    //根据id获取reply
    Reply getReplyById(Integer id);
}
