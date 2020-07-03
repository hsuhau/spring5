package com.hsuhau.spring5.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring整合Junit4
 *
 * @author hsuhau
 * @date 2020/7/4 0:31
 */
// 单元测试框架
@RunWith(SpringJUnit4ClassRunner.class)
// 加载配置文件
@ContextConfiguration("classpath:bean1.xml")
public class Junit4Test {
    @Autowired
    private UserService userService;

    @Test
    public void testJUnit4() {
        System.out.println("hi junit 4");
        userService.accountMoney();
    }
}
