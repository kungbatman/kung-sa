package io.kung.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author kung
 * @Date 2023/2/22 16:53
 * @Version 1.0.0
 * @Description
 */
@SpringBootApplication
@MapperScan(value = {"io.kung.shop.product.mapper"})
@EnableDiscoveryClient
public class ProductStarter {

    public static void main(String[] args) {
        SpringApplication.run(ProductStarter.class, args);
    }
}
