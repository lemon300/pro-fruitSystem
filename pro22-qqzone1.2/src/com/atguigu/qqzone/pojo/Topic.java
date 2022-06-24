package com.atguigu.qqzone.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassNmae Topic
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/7 17:09
 * @Version 1.0
 **/
public class Topic {
    private Integer id;
    private String title;
    private String content;
    private Date topicDate;
    private UserBasic author;

    private List<Reply> replyList ;//一个日志 可能有多条回复。

    public Topic(String title, String content, Date topicDate, UserBasic author) {
        this.title = title;
        this.content = content;
        this.topicDate = topicDate;
        this.author = author;
    }

    public Topic(){

    }

    public Topic(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
