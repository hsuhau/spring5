package com.hsuhau.spring5.service;

import com.hsuhau.spring5.entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class BookServiceTest {

    @Test
    public void testJdbcTemplateAdd() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBookId(2);
        book.setBookName("fabulous");
        book.setBookStatus("running");
        bookService.addBook(book);
    }

    @Test
    public void testJdbcTemplateBatchAdd() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Object[] o1 = {3, "who am i 3", "thinking"};
        Object[] o2 = {4, "who am i 4", "thinking"};
        Object[] o3 = {5, "who am i 5", "thinking"};
        List<Object[]> list = Arrays.asList(o1, o2, o3);
        bookService.batchAddBook(list);
    }

    @Test
    public void testJdbcTemplateDelete() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBook(1);
    }

    @Test
    public void testJdbcTemplateBatchDelete() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Object[] o1 = {3};
        Object[] o2 = {4};
        Object[] o3 = {5};
        List<Object[]> list = Arrays.asList(o1, o2, o3);
        bookService.batchDeleteBook(list);
    }

    @Test
    public void testJdbcTemplateUpdate() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("fabulous");
        book.setBookStatus("waiting");
        bookService.updateBook(book);
    }

    @Test
    public void testJdbcTemplateBatchUpdate() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Object[] o1 = {"who am i 3 update", "thinking-u", 3};
        Object[] o2 = {"who am i 4 update", "thinking-u", 4};
        Object[] o3 = {"who am i 5 update", "thinking-u", 5};
        List<Object[]> list = Arrays.asList(o1, o2, o3);
        bookService.batchUpdateBook(list);
    }

    @Test
    public void testJdbcTemplateQuery() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.queryBookOne(1);
    }

    @Test
    public void testJdbcTemplateQueryList() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.queryBookAll();
    }

    @Test
    public void testJdbcTemplateQueryCount() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.queryBookCount();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
