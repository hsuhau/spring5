package com.hsuhau.spring5.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Spring5整合Junit5
 *
 * @author hsuhau
 * @date 2020/7/4 0:34
 */
/*@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:bean1.xml")*/
// @SpringJunitConfig 复合注解替代上面两个注解完成整合
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class Junit5Test {
    @Autowired
    private UserService userService;

    @Test
    public void testJunit5() {
        System.out.println("hi junit 5");
        userService.accountMoney();
    }
}
