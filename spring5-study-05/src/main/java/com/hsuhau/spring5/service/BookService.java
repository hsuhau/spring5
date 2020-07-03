package com.hsuhau.spring5.service;

import com.hsuhau.spring5.dao.BookDao;
import com.hsuhau.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hsuhau
 * @date 2020/7/3 4:22
 */
@Service
public class BookService {
    // 注入dao
    @Autowired
    private BookDao bookDao;

    /**
     * 添加书本
     *
     * @param book 书
     */
    public void addBook(Book book) {
        bookDao.add(book);
    }

    /**
     * 批量添加书本
     *
     * @param batchArgs 批量参数
     */
    public void batchAddBook(List<Object[]> batchArgs) {
        bookDao.batchAdd(batchArgs);
    }

    /**
     * 删除书本
     *
     * @param bookId ID
     */
    public void deleteBook(Integer bookId) {
        bookDao.delete(bookId);
    }

    /**
     * 批量删除书本
     *
     * @param batchArgs 批量参数
     */
    public void batchDeleteBook(List<Object[]> batchArgs) {
        bookDao.batchDelete(batchArgs);
    }

    /**
     * 修改书本
     *
     * @param book 书
     */
    public void updateBook(Book book) {
        bookDao.update(book);
    }

    /**
     * 批量删除书本
     *
     * @param batchArgs 批量参数
     */
    public void batchUpdateBook(List<Object[]> batchArgs) {
        bookDao.batchUpdate(batchArgs);
    }

    /**
     * 查询单个书本
     *
     * @param bookId ID
     */
    public void queryBookOne(Integer bookId) {
        bookDao.queryOne(bookId);
    }

    /**
     * 查询全部书本
     */
    public void queryBookAll() {
        bookDao.queryAll();
    }

    /**
     * 查询书本数量
     */
    public void queryBookCount() {
        bookDao.queryCount();
    }


}
