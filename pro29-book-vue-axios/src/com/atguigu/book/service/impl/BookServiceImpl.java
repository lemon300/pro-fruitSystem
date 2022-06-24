package com.atguigu.book.service.impl;

import com.atguigu.book.dao.BookDAO;
import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.BookService;

import java.util.List;

/**
 * @ClassNmae BookServiceImpl
 * @Description TODO
 * @Author twj280
 * @Date 2022/5/16 15:44
 * @Version 1.0
 **/
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }

    @Override
    public void updateBook(Book book,Integer count) {
        bookDAO.updateBook(book,count);
    }
}
