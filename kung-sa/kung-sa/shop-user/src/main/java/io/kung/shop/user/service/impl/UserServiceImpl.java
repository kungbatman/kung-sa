package io.kung.shop.user.service.impl;

import io.kung.shop.bean.User;
import io.kung.shop.user.mapper.UserMapper;
import io.kung.shop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author kung
 * @Date 2023/2/22 16:33
 * @Version 1.0.0
 * @Description 用户业务实现类
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectById(userId);
    }

    @Async
    @Override
    public void asyncMethod() {
        log.info("执行了异步任务...");
    }
}