package com.atguigu.qqzone.dao.impl;

import com.atguigu.qqzone.dao.UserBasicDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import com.atguigu.myssm.utils.JDBCUtils;
import com.atguigu.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassNmae UserBasicDAOImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/8 17:38
 * @Version 1.0
 **/
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return load( "SELECT * FROM t_user_basic WHERE loginId = ? AND pwd = ?", loginId, pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        List<UserBasic> userBasicList = executeQuery( "SELECT fid as id FROM t_friend WHERE uid = ?", userBasic.getId());
        return userBasicList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        UserBasic userBasic = load( "select * from t_user_basic where id = ?", id);
        return userBasic;
    }
}
