package com.atguigu.fruit.service.impl;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.fruit.service.FruitService;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassNmae FruitServiceImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/3 18:24
 * @Version 1.0
 **/
public class FruitServiceImpl implements FruitService {
    private FruitDAO fruitDAO = null;

    @Override
    public List<Fruit> getFruitList(String keywords, Integer pageNo) {
        List<Fruit> fruitList = fruitDAO.getFruitList(keywords,pageNo);
        return fruitList;
    }

    @Override
    public void addFruit(Fruit fruit) {
        fruitDAO.addFruit(fruit);
    }

    @Override
    public void deleteFruitById(Integer fid) {
        fruitDAO.delFruitById(fid);
    }

    @Override
    public void updateFruit(Fruit fruit) {
        fruitDAO.updateFruitById(fruit);
    }

    @Override
    public Fruit getFruitById(Integer fid) {
        Fruit fruit = fruitDAO.getFruitById(fid);
        return fruit;
    }

    @Override
    public Integer getPageCount(String keyWords) {
        int totalCount = fruitDAO.getTotalCount(keyWords);

        return (int) Math.ceil(totalCount/5.0);
    }
}
