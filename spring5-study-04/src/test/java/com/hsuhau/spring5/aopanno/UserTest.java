package com.hsuhau.spring5.aopanno;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void testAopAnno() throws Exception{
        /*
          Around 之前..........
          Before..........
          User类 add.........
          Around 之后..........
          After..........
          AfterReturning..........
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
