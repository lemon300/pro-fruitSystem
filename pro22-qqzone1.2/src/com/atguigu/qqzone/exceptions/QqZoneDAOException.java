package com.atguigu.qqzone.exceptions;

/**
 * @ClassNmae QzoneDAOException
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/10 16:08
 * @Version 1.0
 **/
public class QqZoneDAOException extends RuntimeException{
    static final long serialVersionUID = -7034897190745121939L;
    public QqZoneDAOException(String msg){
        super(msg);
    }
}
