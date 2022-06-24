package com.atguigu.qqzone.service.impl;

import com.atguigu.qqzone.dao.HostReplyDAO;
import com.atguigu.qqzone.pojo.HostReply;
import com.atguigu.qqzone.service.HostReplyService;

/**
 * @ClassNmae HostReplyServiceImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/12 12:22
 * @Version 1.0
 **/
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;
    @Override
    public HostReply getHostReplyByReplyID(Integer replyId) {
        HostReply hostReply = hostReplyDAO.getHostReplyByReplyId(replyId);
        return hostReply;
    }

    @Override
    public void delHostReply(HostReply hostReply) {
        hostReplyDAO.delHostReply(hostReply);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        hostReplyDAO.addHostReply(hostReply);
    }
}
