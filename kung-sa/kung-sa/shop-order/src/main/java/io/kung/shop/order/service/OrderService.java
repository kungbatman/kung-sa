package io.kung.shop.order.service;

import io.kung.shop.params.OrderParams;

/**
 * @Author kung
 * @Version 1.0.0
 */
public interface OrderService {

    /**
     * 保存订单
     */
    void saveOrder(OrderParams orderParams);
}
