package io.kung.shop.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.kung.shop.order.handler.MyBlockHandlerClass;
import io.kung.shop.order.handler.MyFallbackClass;
import io.kung.shop.order.service.SentinelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author kung
 * @Date 2023/3/6 11:44
 * @Version 1.0.0
 * @Description
 */
@Slf4j
@Service
public class SentinelServiceImpl implements SentinelService {
    @Override
    @SentinelResource("sendMessage")
    public void sendMessage() {
        System.out.println("测试sentinel的链路流控模式");
    }

    private int count = 0;

    @Override
    @SentinelResource(
            value = "sendMessage2",
            blockHandlerClass = MyBlockHandlerClass.class,
            blockHandler = "blocHandler",
            fallbackClass = MyFallbackClass.class,
            fallback = "fallback"
    )
    public String sendMessage2() {
        count++;
        if (count % 4 == 0) {
            throw new RuntimeException("25%的异常率");
        }
        return "sendMessage2";
    }

//    public String blockHandler(BlockException e) {
//        log.error("限流了:{}", e);
//        return "限流了";
//    }

    public String fallback(Throwable e) {
        log.error("异常了：{}", e);
        return "异常了";
    }

}
