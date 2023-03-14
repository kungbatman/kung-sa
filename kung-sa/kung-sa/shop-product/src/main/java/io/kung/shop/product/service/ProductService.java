package io.kung.shop.product.service;

import io.kung.shop.bean.Product;

/**
 * @Author kung
 * @Version 1.0.0
 */
public interface ProductService {

    /**
     * 根据商品id获取商品信息
     */
    Product getProductById(Long pid);


    /**
     * 扣减商品库存
     */
    int updateProductStockById(Integer count, Long id);
}
