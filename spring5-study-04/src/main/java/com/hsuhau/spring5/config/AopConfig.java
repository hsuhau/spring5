package com.hsuhau.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Aop配置类
 *
 * 完全使用注解开发
 * 创建配置类，不需要创建xml配置文件
 *
 * @author hsuhau
 * @date 2020/7/3 2:12
 */
@Configuration
@ComponentScan(basePackages = {"com.hsuhau"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {

}
