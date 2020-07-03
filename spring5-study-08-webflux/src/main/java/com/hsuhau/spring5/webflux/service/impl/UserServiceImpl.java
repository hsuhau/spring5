package com.hsuhau.spring5.webflux.service.impl;

import com.hsuhau.spring5.webflux.entity.User;
import com.hsuhau.spring5.webflux.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hsuhau
 * @date 2020/7/4 5:18
 */
@Service
public class UserServiceImpl implements UserService {
    // 创建map集合存储数据
    private final Map<Integer, User> userMap = new HashMap<>();

    public UserServiceImpl() {
        this.userMap.put(1, new User("lucy", "woman", 20));
        this.userMap.put(2, new User("mary", "woman", 23));
        this.userMap.put(3, new User("howl", "man", 21));
    }

    @Override
    public Mono<User> getUserById(Integer id) {
        return Mono.justOrEmpty(this.userMap.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.userMap.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            // 想map集合里面放值
            int id = userMap.size() + 1;
            userMap.put(id, person);
        }).thenEmpty(Mono.empty());
    }
}
