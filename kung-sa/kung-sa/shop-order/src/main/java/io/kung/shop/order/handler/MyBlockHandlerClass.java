package io.kung.shop.order.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author kung
 * @Date 2023/3/6 14:40
 * @Version 1.0.0
 * @Description 定义被Sentinel限流时调用的方法
 */
@Slf4j
public class MyBlockHandlerClass {
    public static String blockHandler(BlockException e) {
        log.error("限流处理类:{}", e);
        return "限流处理类";
    }
}
