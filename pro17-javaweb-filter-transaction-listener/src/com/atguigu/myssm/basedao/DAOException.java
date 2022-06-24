package com.atguigu.myssm.basedao;

/**
 * @ClassNmae DAOException
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/5 15:50
 * @Version 1.0
 **/
public class DAOException extends RuntimeException{
    static final long serialVersionUID = -703489719010000000L;
    public DAOException(String msg){
        super(msg);
    }

}
