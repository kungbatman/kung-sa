package io.kung.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author kung
 * @Date 2023/2/22 16:39
 * @Version 1.0.0
 * @Description
 */
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan(value = {"io.kung.shop.user.mapper"})
@EnableDiscoveryClient
@EnableAsync
public class UserStarter {

    public static void main(String[] args) {
        SpringApplication.run(UserStarter.class, args);
    }
}
