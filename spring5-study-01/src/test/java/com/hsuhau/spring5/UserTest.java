package com.hsuhau.spring5;

import com.hsuhau.spring5.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void testAdd() throws Exception {
        // 1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("user-bean.xml");
        // 2 获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
//        user.add();
        user.testSet();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
