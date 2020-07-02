package com.hsuhau.spring5.service;

import com.hsuhau.spring5.dao.impl.UserDaoImpl;

/**
 * @author hsuhau
 * @date 2020/7/1 16:06
 */
public class UserService {

    // 创建UserDao类型属性，生成set方法
    private UserDaoImpl userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add .............");
        userDao.update();
    }
}
