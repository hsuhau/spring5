package com.hsuhau.spring5.dao;

import com.hsuhau.spring5.entity.Book;

import java.util.List;

/**
 * @author hsuhau
 * @date 2020/7/3 4:23
 */
public interface BookDao {
    void add(Book book);

    void batchAdd(List<Object[]> batchArgs);

    void update(Book book);

    void batchUpdate(List<Object[]> batchArgs);

    void queryOne(Integer bookId);

    void queryAll();

    void queryCount();

    void delete(Integer bookId);

    void batchDelete(List<Object[]> batchArgs);
}
