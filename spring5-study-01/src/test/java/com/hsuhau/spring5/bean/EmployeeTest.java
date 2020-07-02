package com.hsuhau.spring5.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {

    @Test
    public void testAdd1() throws Exception {
        // 1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("employee-bean.xml");
        // 2 获取配置创建的对象
        Employee employee = context.getBean("employee", Employee.class);
        employee.add();
    }

    @Test
    public void testAdd2() throws Exception {
        // 1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("employee-bean-2.xml");
        // 2 获取配置创建的对象
        Employee employee = context.getBean("employee", Employee.class);
        employee.add();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
