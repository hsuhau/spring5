package com.hsuhau.spring5.collection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

    @Test
    public void testCollection1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Student student = context.getBean("stu", Student.class);
        student.test();
    }

    @Test
    public void testCollection2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
//        Book book = context.getBean("book", Book.class);
//        book.test();

        // 单例模式
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        // book1 = com.hsuhau.spring5.collection.Book@757942a1
        System.out.println("book1 = " + book1);
        // book2 = com.hsuhau.spring5.collection.Book@757942a1
        System.out.println("book2 = " + book2);

        // 多例模式
        // book1 = com.hsuhau.spring5.collection.Book@757942a1
        // book2 = com.hsuhau.spring5.collection.Book@4a87761d
    }

    @Test
    public void testCollection3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println("course = " + course);
    }
}
