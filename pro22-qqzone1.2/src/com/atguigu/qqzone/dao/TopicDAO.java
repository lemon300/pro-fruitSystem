package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/5/8 17:27
 */
public interface TopicDAO {
    //获取指定用户的日志
    List<Topic> getTopicList(UserBasic userBasic);
    //增加日志
    void addTopic(Topic topic);
    //删除日志
    void delTopic(Topic topic);
    //获取特定日志信息
    Topic getTopic(Integer id);
}
