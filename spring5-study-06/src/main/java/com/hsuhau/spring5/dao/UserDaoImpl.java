package com.hsuhau.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author hsuhau
 * @date 2020/7/3 19:13
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql = "update t_account set money=money-? where username = ?";
        int lucy = jdbcTemplate.update(sql, 100, "lucy");
        System.out.println("lucy = " + lucy);
    }

    @Override
    public void reduceMoney() {
        String sql = "update t_account set money = money + ? where username = ?";
        int mary = jdbcTemplate.update(sql, 100, "mary");
        System.out.println("mary = " + mary);
    }
}
