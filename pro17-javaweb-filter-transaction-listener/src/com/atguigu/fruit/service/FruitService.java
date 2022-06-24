package com.atguigu.fruit.service;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

/**
 * @ClassNmae FruitService
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/3 18:16
 * @Version 1.0
 **/
public interface FruitService {
    //获取水果库存列表
    List<Fruit> getFruitList(String keywords,Integer pageNo);
    //插入一条水果库存信息
    void addFruit(Fruit fruit);
    //根据fid删除一条水果库存信息
    void deleteFruitById(Integer fid);
    //更新一条水果库存数据
    void updateFruit(Fruit fruit);
    //根fid查看指定库存信息
    Fruit getFruitById(Integer fid);
    //获取总页数
    Integer getPageCount(String keyWords);
}
