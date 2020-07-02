package com.hsuhau.spring5.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

    @Test
    public void testAdd() {
        // 1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("user-bean-2.xml");
        // 2 获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
