package io.kung.shop.params;

import lombok.Data;

/**
 * @Author kung
 * @Date 2023/2/22 16:05
 * @Version 1.0.0
 * @Description 订单参数
 */
@Data
public class OrderParams {

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 购买的商品数量
     */
    private Integer count;

    public boolean isEmpty(){
        return (productId == null || productId <= 0) ||
                (userId == null || productId <= 0) ||
                (count == null || count <= 0);
    }
}

