package com.hsuhau.spring5.dao;

import com.hsuhau.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author hsuhau
 * @date 2020/7/3 4:23
 */
@Repository
public class BookDaoImpl implements BookDao {

    // 注入 JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        // 1.创建SQL语句
        String sql = "insert into t_book values(?,?,?)";
        // 2.调用方法实现
        Object[] args = {book.getBookId(), book.getBookName(), book.getBookStatus()};
//        jdbcTemplate.add(sql, book.getBookId(), book.getBookName(), book.getBookStatus());
        int add = jdbcTemplate.update(sql, args);
        System.out.println("add = " + add);
    }

    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        // 1.创建SQL语句
        String sql = "insert into t_book values(?,?,?)";
        // 2.调用方法实现
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    @Override
    public void delete(Integer bookId) {
        // 1.创建SQL语句
        String sql = "delete from t_book where book_id = ?";
        Object[] args = {bookId};
        // 2.调用方法实现
        int delete = jdbcTemplate.update(sql, args);
        System.out.println("delete = " + delete);
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        // 1.创建SQL语句
        String sql = "delete from t_book where book_id = ?";
        // 2.调用方法实现
        int[] batchDelete = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("Arrays.toString(batchDelete) = " + Arrays.toString(batchDelete));
    }


    @Override
    public void update(Book book) {
        // 1.创建SQL语句
        String sql = "update t_book set book_name = ? , book_status = ? where book_id = ?";
        Object[] args = {book.getBookName(), book.getBookStatus(), book.getBookId()};
        // 2.调用方法实现
        int update = jdbcTemplate.update(sql, args);
        System.out.println("update = " + update);
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        // 1.创建SQL语句
        String sql = "update t_book set book_name = ? , book_status = ? where book_id = ?";
        // 2.调用方法实现
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println("Arrays.toString(batchUpdate) = " + Arrays.toString(batchUpdate));
    }

    @Override
    public void queryCount() {
        // 1.创建SQL语句
        String sql = "select count(*) from t_book";
        // 2.调用方法实现
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("count = " + count);
    }

    @Override
    public void queryOne(Integer bookId) {
        // 1.创建SQL语句
        String sql = "select book_id as bookId, book_name as bookName, book_status as bookStatus from t_book where book_id = ?";
        // 2.调用方法实现
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), bookId);
        System.out.println("book = " + book);
    }

    @Override
    public void queryAll() {
        // 1.创建SQL语句
        String sql = "select book_id as bookId, book_name as bookName, book_status as bookStatus from t_book";
        // 2.调用方法实现
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        System.out.println("bookList = " + bookList);
    }
}
