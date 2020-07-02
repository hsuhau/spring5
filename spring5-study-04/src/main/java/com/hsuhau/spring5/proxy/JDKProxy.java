package com.hsuhau.spring5.proxy;

import com.hsuhau.spring5.dao.UserDao;
import com.hsuhau.spring5.dao.impl.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 在软件业，AOP为Aspect Oriented Programming的缩写，<br>
 * 意为：面向切面编程，通过预编译方式和运行期间动态代理实现程序功能的统一维护的一种技术。<br>
 * AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。<br>
 * 利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，<br>
 * 提高程序的可重用性，同时提高了开发的效率。<br>
 *
 * @author hsuhau
 * @date 2020/7/2 23:37
 */
public class JDKProxy {
    public static void main(String[] args) {
        // 创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        /*Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });*/
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result = " + result);
    }
}

/**
 * 创建代理对象代码
 */
class UserDaoProxy implements InvocationHandler {
    private Object object;

    /**
     * 1.把创建的是谁的代理对象，把谁传递过来<br>
     * 有参数构造传递
     *
     * @param object 代理对象
     */
    public UserDaoProxy(Object object) {
        this.object = object;
    }

    /**
     * 增强的逻辑
     *
     * @param proxy 代理
     * @param method 方法
     * @param args 参数
     * @return 返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法之前
        if (method.getName().equals("add")) {
            System.out.println("增强方法为 add");
        }
        args = new Object[]{2, 3};
        System.out.println("方法之前执行" + method.getName() + " :传递的参数..." + Arrays.toString(args));
        // 被增强的方法执行
        Object res = method.invoke(object, args);
        // 方法之后
        System.out.println("方法之后执行" + object);
        return res;
    }
}
