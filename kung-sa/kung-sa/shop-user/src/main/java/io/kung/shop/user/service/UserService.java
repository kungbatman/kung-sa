package io.kung.shop.user.service;

import io.kung.shop.bean.User;

public interface UserService {

    /**
     * 根据id获取用户信息
     */
    User getUserById(Long userId);

    void asyncMethod();
}
