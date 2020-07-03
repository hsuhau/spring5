package com.hsuhau.spring5.reactor;

import java.util.Observable;

/**
 * 响应式编程 Java实现
 *
 * @author hsuhau
 * @date 2020/7/4 2:46
 */
public class Observer extends Observable {
    public static void main(String[] args) {
        Observer observer = new Observer();
        // 添加观察者
        observer.addObserver((o, arg) -> {
            System.out.println("发生变化");
        });
        observer.addObserver((o, arg) -> {
            System.out.println("收到被观察者通知，准备改变");
        });

        // 监控数据变化
        observer.setChanged();

        // 通知
        observer.notifyObservers();
    }
}
