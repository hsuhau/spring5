package com.hsuhau.spring5.webflux.service;

import com.hsuhau.spring5.webflux.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户操作接口
 *
 * @author hsuhau
 * @date 2020/7/4 5:14
 */
public interface UserService {
    /**
     * 根据ID查询用户
     *
     * @param id
     * @return
     */
    Mono<User> getUserById(Integer id);

    /**
     * 查询所有用户
     */
    Flux<User> getAllUser();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Mono<Void> saveUserInfo(Mono<User> user);
}
