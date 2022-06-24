package com.atguigu.qqzone.dao.impl;

import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.myssm.utils.JDBCUtils;
import com.atguigu.qqzone.pojo.HostReply;

/**
 * @ClassNmae hostReplyDAOImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/12 12:30
 * @Version 1.0
 **/
public class hostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        HostReply hostReply = super.load( "select * from t_host_reply where reply = ?", replyId);
        return hostReply;
    }

    @Override
    public void delHostReply(HostReply hostReply) {
        super.executeUpdate( "delete from t_host_reply where reply = ?", hostReply.getReply().getId());
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        super.executeUpdate( "insert into t_host_reply values(0,?,?,?,?)", hostReply.getContent(), hostReply.getHostReplyDate(), hostReply.getAuthor().getId(), hostReply.getReply().getId());
    }
}
