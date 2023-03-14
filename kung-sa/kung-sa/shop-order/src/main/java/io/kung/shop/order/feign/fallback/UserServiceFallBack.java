package io.kung.shop.order.feign.fallback;

import io.kung.shop.bean.User;
import io.kung.shop.order.feign.UserService;
import org.springframework.stereotype.Component;

/**
 * @Author kung
 * @Date 2023/3/3 16:06
 * @Version 1.0.0
 * @Description 用户服务容错类
 */
@Component
public class UserServiceFallBack implements UserService {
    @Override
    public User getUser(Long uid) {
        User user = new User();
        user.setId(-1L);
        return user;
    }
}
