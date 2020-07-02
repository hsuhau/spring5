package com.hsuhau.spring5.dao.impl;

import com.hsuhau.spring5.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author hsuhau
 * @date 2020/7/2 20:31
 */
@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDao add ......");
    }
}
