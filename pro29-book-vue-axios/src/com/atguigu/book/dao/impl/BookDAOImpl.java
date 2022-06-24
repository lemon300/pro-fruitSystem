package com.atguigu.book.dao.impl;

import com.atguigu.book.dao.BookDAO;
import com.atguigu.book.pojo.Book;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @ClassNmae BookDAOImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/16 15:48
 * @Version 1.0
 **/
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return super.executeQuery("select * from t_book");
    }

    @Override
    public Book getBook(Integer id) {
        return super.load("select * from t_book where id = ?",id);
    }

    @Override
    public void updateBook(Book book,Integer count) {
        int i = super.executeUpdate("UPDATE t_book SET saleCount = saleCount + ? , bookCount = bookCount -? WHERE id = ?", count, count, book.getId());
        System.out.println(i);
    }
}
