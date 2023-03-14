package io.kung.shop.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.kung.shop.order.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kung
 * @Date 2023/3/6 11:46
 * @Version 1.0.0
 * @Description
 */
@Slf4j
@RestController
public class SentinelController {

    @Autowired
    private SentinelService sentinelService;

    @GetMapping(value = "/request_sentinel1")
    public String requestSentinel1() {
        log.info("测试Sentinel1");
        sentinelService.sendMessage();
        return "sentinel1";
    }

    @GetMapping(value = "/request_sentinel2")
    public String requestSentinel2() {
        log.info("测试Sentinel2");
        sentinelService.sendMessage();
        return "sentinel2";

    }

    @GetMapping(value = "/request_sentinel3")
    @SentinelResource("request_sentinel3")
    public String requestSentinel3(String header, String body) {
        log.info("测试sentinel3");
        return "sentinel3";
    }

    private int count = 0;

    @GetMapping(value = "/request_sentinel4")
    @SentinelResource("request_sentinel4")
    public String requestSentinel4() {
        log.info("测试Sentinel4");
        count++;
        //模拟异常，比例为50%
        if (count % 2 == 0) {
            throw new RuntimeException("演示基于异常比例熔断");
        }

        return "sentinel4";
    }

    @GetMapping(value = "/request_sentinel5")
    @SentinelResource("request_sentinel5")
    public String requestSentinel5() {
        log.info("测试sentinel5");
        return "sentinel5";
    }

    @GetMapping(value = "/request_sentinel6")
    public String requestSentinel6() {
        log.info("测试sentinel6");
        return sentinelService.sendMessage2();
    }
}

