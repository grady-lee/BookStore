package com.turing.book.dao;

import com.turing.book.pojo.Book;

import java.util.List;

public interface BookDAO {

    List<Book> bookList();

    int del(Integer bid);
    
    int update(Book book);

}
