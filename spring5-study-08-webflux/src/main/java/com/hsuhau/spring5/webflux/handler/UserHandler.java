package com.hsuhau.spring5.webflux.handler;

import com.hsuhau.spring5.webflux.entity.User;
import com.hsuhau.spring5.webflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author hsuhau
 * @date 2020/7/4 5:58
 */
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据ID查询
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> getUserById(ServerRequest request) {
        // 获取Id值
        Integer userId = Integer.valueOf(request.pathVariable("id"));
        // 空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        // 调用service方法得到数据
        Mono<User> userMono = this.userService.getUserById(userId);
        // 把userMono进行转换返回
        // 使用Reactor操作符flatMap
        Mono<ServerResponse> serverResponseMono = userMono.flatMap(
                person -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(person)))
                .switchIfEmpty(notFound);
        return serverResponseMono;
    }

    /**
     * 查询所有
     *
     * @return
     */
    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        // 调用service里面的方法得到结果
        Flux<User> userFlux = this.userService.getAllUser();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userFlux, User.class);
    }


    /**
     * 添加
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }
}
