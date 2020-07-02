package com.hsuhau.spring5.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * IOC操作Bean管理（xml注入集合属性）<br>
 * 1、注入数组类型属性<br>
 * 2、注入List集合类型属性<br>
 * 3、注入Map集合类型属性<br>
 * 4、注入Set集合类型属性<br>
 * <p>
 * 创建类，定义数组、List、Map、Set<br>
 *
 * @author hsuhau
 * @date 2020/7/2 1:35
 */
public class Student {
    /**
     * 1 数组类型属性
     */
    private String[] courses;

    /**
     * 2 List集合类型属性
     */
    private List<String> list;

    /**
     * 3 Map集合类型属性
     */
    private Map<String, String> maps;

    /**
     * 4 Set集合类型属性
     */
    private Set<String> sets;

    /**
     * 学生所学多门课程
     */
    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void test() {
        System.out.println("Arrays.toString(courses) = " + Arrays.toString(courses));
        System.out.println("list = " + list);
        System.out.println("maps = " + maps);
        System.out.println("sets = " + sets);
        System.out.println("courseList: ");
        courseList.forEach(t -> System.out.println("t.getCname() = " + t.getCname()));
    }
}
