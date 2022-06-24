package com.atguigu.qqzone.service;

import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.pojo.Reply;

/**
 * @author twj28
 * @create 2022 2022/5/12 9:57
 */
public interface HostReplyService {
    //根据reply获取主人回复
    HostReply getHostReplyByReplyID(Integer replyId);
    //删除主人回复
    void delHostReply(HostReply hostReply);
    //添加主人回复
    void addHostReply(HostReply hostReply);
}
