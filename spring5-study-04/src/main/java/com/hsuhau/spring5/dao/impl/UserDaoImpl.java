package com.hsuhau.spring5.dao.impl;

import com.hsuhau.spring5.dao.UserDao;

/**
 * @author hsuhau
 * @date 2020/7/2 23:31
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        System.out.println("add 方法执行了");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update 方法执行了");
        return id;
    }
}
