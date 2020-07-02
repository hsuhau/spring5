package com.hsuhau.spring5.service;

import com.hsuhau.spring5.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 在注解里面value属性值可以省略不写
 * 默认值是类名称，首字母小写
 *
 * @author hsuhau
 * @date 2020/7/2 19:51
 */
//@Component(value = "userService")
@Service
public class UserService {
    /**
     * 定义类型属性
     * 不需要添加set方法，内部封装了set方法
     * 添加注入属性注解
     * <p>
     * {@link @Autowired}:根据属性类型进行自动装配
     * {@link @Qualifier}:根据属性名称进行注入
     * {@link @Resource}:可以根据类型注入，可以根据名称注入
     * {@link @Value}:注入基本类型属性
     */
//    @Autowired
//    @Qualifier(value = "userDaoImpl1")
//    @Resource // 默认根据属性类型进行自动装配
    @Resource(name = "userDaoImpl1")
    private UserDao userDao;

    public void add() {
        System.out.println("service add......");
        userDao.add();
    }
}
