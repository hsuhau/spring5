package com.hsuhau.spring5.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 响应式编程 Reactor实现<br>
 *
 * 响应式编程操作中，Reactor是满足Reactive规范框架<br>
 * Reactor有两个核心类，Mono和Flux，这两个类实现接口Publisher，提供丰富操作符。Flux对象实现发布者，返回N个元素；Mono实现发布者，返回0或1个元素<br>
 * Flux和Mono都是数据流的发布者，使用Flux和Mono都可以发出三种数据信号<br>
 * &#9; 元素值<br>
 * &#9;&#9;终止信号 - 用于告诉订阅者数据流结束了<br>
 * &#9;&#9;错误信号 - 终止数据流同时把错误信息传递给订阅者<br>
 * &#9;&#9;完成信号<br>
 *
 * @author hsuhau
 * @date 2020/7/4 3:17
 */
public class ReactorTest {
    public static void main(String[] args) {
        // just方法直接声明
        Flux.just(1, 2, 3, 4).subscribe(System.out::print);
        Mono.just(1).subscribe(System.out::print);

        // 其他的方法
        Integer[] array = {1, 2, 3, 4};
        Flux.fromArray(array);

        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);

        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);
    }
}
