package com.hsuhau.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 有多个增强类多同一个的方法进行增强，设置增强类优先级
 * 在增强类上面添加注解@Order（数字类型值）,数字类型值越小优先级越高
 *
 * @author hsuhau
 * @date 2020/7/3 1:45
 */
@Component
@Aspect
@Order(value = 1)
public class PersonProxy {
    @Before(value = "execution(* com.hsuhau.spring5.aopanno.User.add(..))")
    public void before() {
        System.out.println("Person Before");
    }
}
