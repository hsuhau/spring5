package com.hsuhau.spring5.factorybean;

import com.hsuhau.spring5.collection.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author hsuhau
 * @date 2020/7/2 3:24
 */
public class MyBean implements FactoryBean<Course> {
    @Override
    public boolean isSingleton() {
        return false;
    }

    /**
     * 定义返回 Bean
     *
     * @return
     * @throws Exception
     */
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
