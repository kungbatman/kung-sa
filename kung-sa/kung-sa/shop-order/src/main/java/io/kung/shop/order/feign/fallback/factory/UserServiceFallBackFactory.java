package io.kung.shop.order.feign.fallback.factory;

import feign.hystrix.FallbackFactory;
import io.kung.shop.bean.User;
import io.kung.shop.order.feign.UserService;
import org.springframework.stereotype.Component;

/**
 * @Author kung
 * @Date 2023/3/3 16:23
 * @Version 1.0.0
 * @Description 用户微服务容错Factory
 */
@Component
public class UserServiceFallBackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable cause) {
        return new UserService() {
            @Override
            public User getUser(Long uid) {
                User user = new User();
                user.setId(-1L);
                return user;
            }
        };
    }
}
