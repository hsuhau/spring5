package com.hsuhau.spring5.service;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 函数式风格创建对象，交给Spring进行管理
 *
 * @author hsuhau
 * @date 2020/7/4 0:17
 */
public class FunctionalStyleTest {
    @Test
    public void test() {
        // 1.创建 GenericApplicationContext 对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 2.调用context的方法对象注册
        context.refresh();
//        context.registerBean(UserService.class, () -> new UserService());
//        context.registerBean(UserService.class, UserService::new);
        context.registerBean("user1", UserService.class, UserService::new);
        // 3.获取在Spring注册的对象
        // org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'userService' available
//        UserService userService = ((UserService) context.getBean("userService"));
        // userService = com.hsuhau.spring5.service.UserService@4082ba93
//        UserService userService = ((UserService) context.getBean("com.hsuhau.spring5.service.UserService"));
        UserService userService = ((UserService) context.getBean("user1"));
        System.out.println("userService = " + userService);
    }
}
