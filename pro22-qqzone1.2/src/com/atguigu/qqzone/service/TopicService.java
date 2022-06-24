package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/5/10 16:50
 */
public interface TopicService {
    //获取所有日志
    List<Topic> getTopicList(UserBasic userBasic);
    //根据id获取日志
    Topic getTopicById(Integer id);
    //根据id获取指定的topic信息，包含这个topic关联的作者信息
    public Topic getTopic(Integer id);
    //删除日志topic
    void delTopic(Topic topic);
    //添加日志
    void addTopic(Topic topic);
}
