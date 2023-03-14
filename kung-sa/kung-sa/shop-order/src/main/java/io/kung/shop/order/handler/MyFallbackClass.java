package io.kung.shop.order.handler;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author kung
 * @Date 2023/3/6 14:40
 * @Version 1.0.0
 * @Description 定义异常时调用的方法
 */
@Slf4j
public class MyFallbackClass {

    public static String fallback(Throwable e) {
        log.error("异常处理类：{}" , e);
        return "异常处理类";
    }
}
