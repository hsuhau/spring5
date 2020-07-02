package com.hsuhau.spring5.bean;

/**
 * 员工类
 *
 * @author hsuhau
 * @date 2020/7/1 17:56
 */
public class Employee {
    private String ename;
    private String gender;
    // 员工属于某一个部门，适用对象形式
    private Department department;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void add() {
        System.out.println("employee name = " + ename);
        System.out.println("employee gender = " + gender);
        System.out.println("department name = " + department.getDname());
    }
}
