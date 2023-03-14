package io.kung.shop.product.service.impl;

import io.kung.shop.bean.Product;
import io.kung.shop.product.mapper.ProductMapper;
import io.kung.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author kung
 * @Date 2023/2/22 16:57
 * @Version 1.0.0
 * @Description
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(Long pid) {
        return productMapper.selectById(pid);
    }

    @Override
    public int updateProductStockById(Integer count, Long id) {
        return productMapper.updateProductStockById(count, id);
    }
}
