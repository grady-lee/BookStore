package com.turing.book.dao.impl;

import com.turing.book.dao.BookDAO;
import com.turing.book.pojo.Book;
import com.turing.book.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public List<Book> bookList() {
        QueryRunner queryRunner = new QueryRunner();
        try {
            List<Book> books = queryRunner.query(JDBCUtils.getConnection(),
                    "select * from book",
                    new BeanListHandler<Book>(Book.class));
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int del(Integer bid) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            int rows = queryRunner.update(JDBCUtils.getConnection(),
                    "delete from book where bid = ?",
                    bid);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Book book) {
        return 0;
    }

}
