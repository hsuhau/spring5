package com.hsuhau.spring5.bean;

/**
 * @author hsuhau
 * @date 2020/7/1 15:18
 */
public class User {

    // 创建属性
    private String name;

    private String address;

    // 创建属性对应的set方法
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 有参构造器
   /* public User(String name, String address) {
        this.name = name;
        this.address = address;
    }*/

    public void add() {
        System.out.println("add.........");
    }

    public void testSet() {
        System.out.println(name + "::" + address);
    }
}
