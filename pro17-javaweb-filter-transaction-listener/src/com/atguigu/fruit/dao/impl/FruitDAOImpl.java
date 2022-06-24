package com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.exceptions.FruitDAOException;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.fruit.utils.JDBCUtils;
import com.atguigu.myssm.basedao.BaseDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/4/7 16:52
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO {
    private Connection conn = null;

    @Override
    public List getFruitList(String keywords,int pageNo) {

        try {
            conn = JDBCUtils.getThreadLocalConn();
            String sql = "SELECT * FROM t_fruit where fname like ? or remark like ? LIMIT  ?,5";
            List<Fruit> fruitList = getForList(conn, sql,"%"+ keywords + "%","%"+ keywords + "%",(pageNo - 1)*5);
            return fruitList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FruitDAOException("Fruit DAO getFruitList 出问题了。。。");
        } finally {
            JDBCUtils.closeResource(conn);

        }
    }

    @Override
    public Fruit getFruitById(int fid) {
        try {
            conn = JDBCUtils.getThreadLocalConn();
            String sql = "select * from t_fruit where fid = ?";
            Fruit fruit = getInstance(conn, sql, fid);
            return fruit;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FruitDAOException("Fruit DAO getFruitById 出问题了。。。");
        } finally {
            JDBCUtils.closeResource(conn);
        }
    }

    @Override
    public int updateFruitById(Fruit fruit) {
        try {
            conn = JDBCUtils.getThreadLocalConn();
            int updateCount = update(conn, "update t_fruit set fname = ?,price = ?,fcount = ?,remark = ? where fid = ?", fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark(), fruit.getFid());
            return updateCount;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FruitDAOException("Fruit DAO updateFruitById 出问题了。。。");
        } finally {
            JDBCUtils.closeResource(conn);
        }
    }

    @Override
    public int delFruitById(int fid) {
        try {
            conn = JDBCUtils.getThreadLocalConn();
            int delCount = update(conn, "delete from t_fruit where fid = ?", fid);
            return delCount;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FruitDAOException("Fruit DAO delFruitById 出问题了。。。");
        } finally {
            JDBCUtils.closeResource(conn);
        }
    }

    @Override
    public int addFruit(Fruit fruit) {
        try {
            conn = JDBCUtils.getThreadLocalConn();
            int addCount = update(conn, "insert into t_fruit(fname,price,fcount,remark) values(?,?,?,?)", fruit.getFname(), fruit.getPrice(), fruit.getFcount(), fruit.getRemark());
            return addCount;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FruitDAOException("Fruit DAO addFruit 出问题了。。。");
        } finally {
            JDBCUtils.closeResource(conn);
        }
    }

    @Override
    public int getTotalCount(String keywords) {
        try {
            conn = JDBCUtils.getThreadLocalConn();
            return  ((Long)super.getValue(conn,"select count(*) from t_fruit where fname like ? or remark like ?","%"+ keywords + "%","%"+ keywords + "%")[0]).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new FruitDAOException("Fruit DAO getTotalCount 出问题了。。。");
        } finally{
        JDBCUtils.closeResource(conn);
        }
    }
}
