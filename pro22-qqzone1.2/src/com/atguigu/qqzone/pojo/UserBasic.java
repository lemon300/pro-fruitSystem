package com.atguigu.qqzone.pojo;

import java.util.List;

/**
 * @ClassNmae UserBasic
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/7 17:08
 * @Version 1.0
 **/
public class UserBasic {
    private Integer id;

    public UserBasic(Integer id) {
        this.id = id;
    }

    private String loginId;
    private String nickName;
    private String pwd;
    private String headImg;

    private UserDetail userDetail;  //可能会调用详细信息
    private List<Topic> topicList;  //有多条日志
    private List<UserBasic> friendList; //有多个好友

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<UserBasic> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<UserBasic> friendList) {
        this.friendList = friendList;
    }



    public UserBasic(){

    }
}
