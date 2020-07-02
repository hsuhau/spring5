package com.hsuhau.spring5.dao.impl;

import com.hsuhau.spring5.dao.UserDao;

/**
 * @author hsuhau
 * @date 2020/7/1 16:09
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("dao update.............");
    }
}
