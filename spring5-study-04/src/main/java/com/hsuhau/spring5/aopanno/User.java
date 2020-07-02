package com.hsuhau.spring5.aopanno;

import org.springframework.stereotype.Component;

/**
 * @author hsuhau
 * @date 2020/7/3 0:56
 */
@Component
public class User {
    public void add() {
        /**
         * Around 之前..........
         * Before..........
         * After....... ...
         * AfterThrowing..........
         *
         * int i = 10 /0;
         */

        System.out.println("User类 add.........");
    }
}
