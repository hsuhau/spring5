package com.hsuhau.spring5.service;

import org.junit.Test;
import org.springframework.lang.Nullable;

/**
 * {@link org.springframework.lang.Nullable}注解可以使用在方法上面，属性上面，参数上面，表示方法返回可以为空，属性值可以为空，参数值可以为空<br>
 * 1. 注解用在方法上面，方法返回值可以为空<br>
 * 2. 注解使用在方法参数里面，方法参数可以为空<br>
 * 3. 注解使用在属性上面，属性值可以为空<br>
 *
 * @author hsuhau
 * @date 2020/7/4 0:06
 */
public class NullableTest {
    @Nullable
    private Object object;

    @Test
    @Nullable
    private String test(@Nullable Object o) {
        System.out.println("fabulous");
        return null;
    }

}
