package com.atguigu.fruit.dao;



import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author twj28
 * @create 2022 2022/4/7 16:39
 */
public interface FruitDAO {
    //获取水果库存的集合
    List<Fruit> getFruitList(String keywords,int pageNo);
    //通过指定fid返回一个水果对象
    Fruit getFruitById(int fid);
    //通过fid更新
    int updateFruitById(Fruit fruit);
    //通过指定fid删除Fruit对象
    int delFruitById(int fid);
    //添加fruit对象到表中
    int addFruit(Fruit fruit);
    //获取特定的值
    int getTotalCount(String keywords);

}

