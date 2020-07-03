package com.hsuhau.spring5.webflux.controller;

import com.hsuhau.spring5.webflux.entity.User;
import com.hsuhau.spring5.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author hsuhau
 * @date 2020/7/4 5:30
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * ID查询
     *
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/user")
    public Flux<User> getUsers() {
        return userService.getAllUser();
    }

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @PostMapping("/user/save")
    public Mono<Void> saveUser(@RequestBody User user) {
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }
}
