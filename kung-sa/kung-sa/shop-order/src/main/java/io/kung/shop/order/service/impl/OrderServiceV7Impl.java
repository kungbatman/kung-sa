package io.kung.shop.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import io.kung.shop.bean.Order;
import io.kung.shop.bean.OrderItem;
import io.kung.shop.bean.Product;
import io.kung.shop.bean.User;
import io.kung.shop.order.feign.ProductService;
import io.kung.shop.order.feign.UserService;
import io.kung.shop.order.mapper.OrderItemMapper;
import io.kung.shop.order.mapper.OrderMapper;
import io.kung.shop.order.service.OrderService;
import io.kung.shop.params.OrderParams;
import io.kung.shop.utils.constants.HttpCode;
import io.kung.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Author kung
 * @Date 2023/3/9 11:32
 * @Version 1.0.0
 * @Description
 */
@Slf4j
@Service("OrderServiceV7")
public class OrderServiceV7Impl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(OrderParams orderParams) {
        if (orderParams.isEmpty()) {
            throw new RuntimeException("参数异常: " + JSONObject.toJSONString(orderParams));
        }

        User user = userService.getUser(orderParams.getUserId());
        if (user == null) {
            throw new RuntimeException("未获取到用户信息: " + JSONObject.toJSONString(orderParams));
        }
        if (user.getId() == -1) {
            throw new RuntimeException("触发了用户微服务的容错逻辑" + JSONObject.toJSONString(orderParams));
        }
        Product product = productService.getProduct(orderParams.getProductId());
        if (product == null) {
            throw new RuntimeException("未获取到商品信息: " + JSONObject.toJSONString(orderParams));
        }
        if (product.getId() == -1) {
            throw new RuntimeException("触发了商品微服务的容错逻辑: " + JSONObject.toJSONString(orderParams));
        }
        if (product.getProStock() < orderParams.getCount()) {
            throw new RuntimeException("商品库存不足: " + JSONObject.toJSONString(orderParams));
        }
        Order order = new Order();
        order.setAddress(user.getAddress());
        order.setPhone(user.getPhone());
        order.setUserId(user.getId());
        order.setUsername(user.getUsername());
        order.setTotalPrice(product.getProPrice().multiply(BigDecimal.valueOf(orderParams.getCount())));
        orderMapper.insert(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setNumber(orderParams.getCount());
        orderItem.setOrderId(order.getId());
        orderItem.setProId(product.getId());
        orderItem.setProName(product.getProName());
        orderItem.setProPrice(product.getProPrice());
        orderItemMapper.insert(orderItem);

        Result<Integer> result = productService.updateCount(orderParams.getProductId(), orderParams.getCount());
        if (result.getCode() != HttpCode.SUCCESS) {
            throw new RuntimeException("库存扣减失败");
        }
        log.info("库存扣减成功");
        rocketMQTemplate.convertAndSend("order-topic", order);
    }
}
