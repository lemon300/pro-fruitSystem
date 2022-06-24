package com.atguigu.fruit.exceptions;

/**
 * @ClassNmae FruitDAOException
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/5 16:16
 * @Version 1.0
 **/
public class FruitDAOException extends RuntimeException{
    static final long serialVersionUID = -703489719074512121L;
    public FruitDAOException(String msg){
        super(msg);
    }

}
