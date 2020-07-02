package com.hsuhau.spring5.collection;

import java.util.List;

/**
 * @author hsuhau
 * @date 2020/7/2 3:03
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test() {
        System.out.println("list = " + list);
    }
}
