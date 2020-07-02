package com.hsuhau.spring5.bean;

/**
 * 1、 生命周期<br>
 * a)   从对象创建到对象销毁的过程<br>
 * <p>
 * 2、 Bean生命周期<br>
 * 1. 通过构造器创建Bean实例（无参数构造）<br>
 * 2. 为Bean的属性设置值和其他bean引用（调用set方法）<br>
 * 3. 把Bean实例传递Bean后置处理器的方法<br>
 * 4. 调用Bean的初始化的方法（需要进行配置初始化的方法）<br>
 * 5. 把Bean实例传递Bean后置处理器的方法<br>
 * 6. Bean可以使用了（对象获取到了）<br>
 * 7. 当容器关闭时候，调用Bean的销毁的方法（需要进行配置销毁的方法）<br>
 *
 * @author hsuhau
 * @date 2020/7/2 15:44
 */
public class Orders {
    private String oname;

    public Orders() {
        System.out.println("第一步 执行无参数构造创建Bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步 调用set方法设置属性值");
    }

    /**
     * 创建执行的初始化的方法
     */
    public void initMethod() {
        System.out.println("第四步 执行初始化的方法");
    }

    /**
     * 创建执行的销毁的方法
     */
    public void destroyMethod() {
        System.out.println("第七步 执行销毁的方法");
    }
}
