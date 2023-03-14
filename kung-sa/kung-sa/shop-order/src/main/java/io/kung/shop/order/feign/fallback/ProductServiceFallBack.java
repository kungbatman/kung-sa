package io.kung.shop.order.feign.fallback;

import io.kung.shop.bean.Product;
import io.kung.shop.order.feign.ProductService;
import io.kung.shop.utils.resp.Result;
import org.springframework.stereotype.Component;

/**
 * @Author kung
 * @Date 2023/3/3 16:08
 * @Version 1.0.0
 * @Description 商品微服务容错类
 */
@Component
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product getProduct(Long pid) {
        Product product = new Product();
        product.setId(-1L);
        return product;
    }

    @Override
    public Result<Integer> updateCount(Long pid, Integer count) {
        Result<Integer> result = new Result<>();
        result.setCode(1001);
        result.setCodeMsg("触发了容错逻辑");
        return result;
    }
}
