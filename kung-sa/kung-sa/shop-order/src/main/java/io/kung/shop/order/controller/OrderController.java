package io.kung.shop.order.controller;

import com.alibaba.fastjson.JSONObject;
import io.kung.shop.order.service.OrderService;
import io.kung.shop.params.OrderParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kung
 * @Date 2023/2/22 17:15
 * @Version 1.0.0
 * @Description
 */
@Slf4j
@RestController
public class OrderController {
    @Autowired
    @Qualifier(value = "OrderServiceV8")
    private OrderService orderService;

    @GetMapping(value = "/submit_order")
    public String submitOrder(OrderParams orderParams) {
        log.info("提交订单时传递的参数：{}", JSONObject.toJSONString(orderParams));
        orderService.saveOrder(orderParams);
        return "success";
    }

    @GetMapping(value = "/concurrent_request")
    public String concurrentRequest() {
        log.info("测试业务在高并发场景下是否存在问题");
        return "kung";
    }

    @GetMapping(value = "/test_sentinel")
    public String testSentinel() {
        log.info("测试Sentinel");
        return "sentinel";
    }

    @GetMapping(value = "/test_sentinel2")
    public String testSentinel2() {
        log.info("测试Sentinel2");
        return "sentinel2";
    }
}
