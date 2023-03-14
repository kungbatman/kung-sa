package io.kung.shop.order.feign;

import io.kung.shop.bean.User;
import io.kung.shop.order.feign.fallback.factory.UserServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author kung
 * @Version 1.0.0
 */
//@FeignClient(value = "server-user", fallback = UserServiceFallBack.class)
@FeignClient(value = "server-user", fallbackFactory = UserServiceFallBackFactory.class)
public interface UserService {
    @GetMapping(value = "/user/get/{uid}")
    User getUser(@PathVariable("uid") Long uid);
}
