package com.hsuhau.spring5.webflux.router;

import com.hsuhau.spring5.webflux.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * 使用WebClient调用
 *
 * @author hsuhau
 * @date 2020/7/4 7:03
 */
public class Client {
    public static void main(String[] args) {
        // 调用服务器地址
        WebClient webClient = WebClient.create("http://localhost:10865");

        // 根据ID查询
        String id = "1";
        User user = webClient
                .get()
                .uri("/user/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
        System.out.println("user.toString() = " + user.toString());

        // 查询所有
        Flux<User> userFlux = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
        userFlux.map(User::getName).buffer().doOnNext(System.out::print).blockFirst();
    }
}
