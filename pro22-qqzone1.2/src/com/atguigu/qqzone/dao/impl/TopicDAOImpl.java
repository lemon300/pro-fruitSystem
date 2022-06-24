package com.atguigu.qqzone.dao.impl;

import com.atguigu.qqzone.dao.TopicDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.myssm.utils.JDBCUtils;
import com.atguigu.qqzone.pojo.Topic;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassNmae TopicDAOImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/8 20:21
 * @Version 1.0
 **/
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        List<Topic> topicList = executeQuery( "select * from t_topic where author = ?", userBasic.getId());
        return topicList;
    }

    @Override
    public void addTopic(Topic topic) {
        super.executeUpdate( "insert into t_topic values(0,?,?,?,?)", topic.getTitle(), topic.getContent(), topic.getTopicDate(), topic.getAuthor().getId());
    }

    @Override
    public void delTopic(Topic topic) {
        super.executeUpdate( "delete from t_topic where id = ?", topic.getId());
    }

    @Override
    public Topic getTopic(Integer id) {
        return load( "select * from t_topic where id = ?", id);
    }
}
