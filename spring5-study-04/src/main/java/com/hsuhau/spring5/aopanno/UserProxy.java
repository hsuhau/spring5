package com.hsuhau.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强的类
 * <p>
 * 创建增强类（编写增强编辑）
 * 1。在增强类里面，创建方法，让不同方法代表不同方法代表不同通知类型
 *
 * @author hsuhau
 * @date 2020/7/3 0:57
 */
@Component
@Aspect // 生成代理对象
//@Order(value = 3)
@Order(3)
public class UserProxy {

    /**
     * 相同切入点抽取
     */
    @Pointcut(value = "execution(* com.hsuhau.spring5.aopanno.User.add(..))")
    public void pointcut() {

    }

    /**
     * 前置通知
     * {@link org.aspectj.lang.annotation.Before} 注解表示作为前置通知
     */
//    @Before(value = "execution(* com.hsuhau.spring5.aopanno.User.add(..))")
    @Before(value = "pointcut()")
    public void before() {
        System.out.println("Before..........");
    }

    /**
     * 后置通知
     */
//    @After(value = "execution(* com.hsuhau.spring5.aopanno.User.add(..))")
    @After(value = "pointcut()")
    public void after() {
        System.out.println("After..........");
    }

    /**
     * 返回通知
     */
//    @AfterReturning(value = "execution(* com.hsuhau.spring5.aopanno.User.add(..))")
    @AfterReturning(value = "pointcut()")
    public void afterReturning() {
        System.out.println("AfterReturning..........");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing(value = "execution(* com.hsuhau.spring5.aopanno.User.add(..))")
    @AfterThrowing(value = "pointcut()")
    public void afterException() {
        System.out.println("AfterThrowing..........");
    }

    /**
     * 环绕通知
     */
//    @Around(value = "execution(* com.hsuhau.spring5.aopanno.User.add(..))")
    @Around(value = "pointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around 之前..........");

        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("Around 之后..........");
    }

}
