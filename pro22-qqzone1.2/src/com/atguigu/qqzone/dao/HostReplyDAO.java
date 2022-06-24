package com.atguigu.qqzone.dao;

import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;

/**
 * @author twj28
 * @create 2022 2022/5/8 17:38
 */
public interface HostReplyDAO {
    HostReply getHostReplyByReplyId(Integer replyId);
    //删除主人回复
    void delHostReply(HostReply hostReply);
    //添加主人回复
    void addHostReply(HostReply hostReply);
}
