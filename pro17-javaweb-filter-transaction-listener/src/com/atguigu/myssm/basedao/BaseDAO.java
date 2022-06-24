package com.atguigu.myssm.basedao;


import com.atguigu.fruit.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/4/7 15:50
 */

public class BaseDAO<T> {
    private Class clazz;

    {
        //获取父类的泛型参数
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz = (Class) actualTypeArguments[0];
    }

    /**
     * @return int
     * @Author: twj280
     * @Description: 增删改 通用方式，返回修改条数
     * @date: 10:37 2022/4/8
     * @Param: [conn, sql, args]
     **/
    public int update(Connection conn, String sql, Object... args) {


        PreparedStatement ps = null;
        try {
            boolean insertFlag = false;
            insertFlag = sql.trim().toUpperCase().startsWith("INSERT");
            if (insertFlag) {
                //预编译sql
                ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//获取自增列方式
                //填充占位符
                setParam(ps, args);
                //执行sql
                ps.executeUpdate();
                //获取主键
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return ((Long) rs.getLong(1)).intValue();
                }
            } else {
                //预编译sql
                ps = conn.prepareStatement(sql);
                //填充占位符
                setParam(ps, args);
                //执行sql
                return ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO update 出错了。。。");
        } finally {
            //关闭资源
            JDBCUtils.closeResource(null, ps);
        }
        return 0;
    }

    /**
     * @return T
     * @Author: twj280
     * @Description: 通用查询操作，返回一条记录
     * @date: 10:38 2022/4/8
     * @Param: [conn, sql, args]
     **/
    public T getInstance(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //预处理sql
            ps = conn.prepareStatement(sql);
            //填充占位符
            setParam(ps, args);
            //执行，并获取结果集
            rs = ps.executeQuery();
            if (rs.next()) {
                T t = (T) clazz.newInstance();
                //得到表的元数据
                ResultSetMetaData rsm = rs.getMetaData();
                //获取列数
                int columnCount = rsm.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsm.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO getInstance 出错了。。。");
        } finally {

            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    /**
     * @return java.util.List<T>
     * @Author: twj280
     * @Description: 通用查询操作，返回多条记录
     * @date: 10:38 2022/4/8
     * @Param: [conn, sql, args]
     **/
    public List<T> getForList(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //预处理sql
            ps = conn.prepareStatement(sql);
            //填充占位符
            setParam(ps, args);
            //执行，并获取结果集
            rs = ps.executeQuery();
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                T t = (T) clazz.newInstance();
                //得到表的元数据

                ResultSetMetaData rsm = rs.getMetaData();
                //获取列数
                int columnCount = rsm.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsm.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    if (field != null) {
                        field.setAccessible(true);
                        field.set(t, columnValue);
                    }
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO getForList 出错了");
        } finally {
            JDBCUtils.closeResource(null, ps, rs);
        }
    }

    /**
     * @return T
     * @Author: twj280
     * @Description: 查询特定值，返回一条记录
     * @date: 10:38 2022/4/8
     * @Param: [conn, sql]
     **/
    public Object[] getValue(Connection conn, String sql,Object ...args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //预处理sql
            ps = conn.prepareStatement(sql);
            setParam(ps,args);
            //执行，并获取结果集
            rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int columnCount = rsm.getColumnCount();
            Object[] columnValueArr = new Object[columnCount];
            if (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    columnValueArr[i] = columnValue;

                }

                return columnValueArr;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("BaseDAO getValue 出错了。。。");
        } finally {

            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    private void setParam(PreparedStatement ps, Object... args) {
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                try {
                    ps.setObject(i + 1, args[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new DAOException("BaseDAO setParam出错了。。。");
                }
            }

        }
    }
}
