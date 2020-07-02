package com.hsuhau.spring5.autowire;

/**
 * @author hsuhau
 * @date 2020/7/2 15:39
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void test() {
        System.out.println("dept = " + dept);
    }
}
