package com.atguigu.book.dao;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.OrderItem;

import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/5/18 14:02
 */
public interface OrderItemDAO {
    //增加订单项目
    void addOrderItem(OrderItem orderItem);

    List<OrderItem> getOrderItemList(OrderBean orderBean);

    Integer getBuyCount(OrderBean orderBean);
}
