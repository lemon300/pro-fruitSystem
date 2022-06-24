package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/5/8 17:31
 */
public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReply(Reply reply);
    //根据id获取指定回复
    Reply getReplyById(Integer id);
}
