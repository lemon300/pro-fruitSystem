package com.atguigu.qqzone.dao.impl;

import com.atguigu.qqzone.dao.ReplyDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.myssm.utils.JDBCUtils;
import com.atguigu.qqzone.pojo.Reply;
import com.atguigu.qqzone.pojo.Topic;

import java.util.List;

/**
 * @ClassNmae ReplyDAOImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/12 9:37
 * @Version 1.0
 **/
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        List<Reply> replyList = super.executeQuery( "select * from t_reply where topic = ?", topic.getId());
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        super.executeUpdate( "insert into t_reply values(0,?,?,?,?)", reply.getContent(), reply.getReplyDate(), reply.getAuthor().getId(), reply.getTopic().getId());
    }

    @Override
    public void delReply(Reply reply) {
        super.executeUpdate( "delete from t_reply where id = ?", reply.getId());
    }

    @Override
    public Reply getReplyById(Integer id) {
        Reply reply = super.load("select * from t_reply where id = ?", id);
        return reply;
    }
}
