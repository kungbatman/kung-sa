package io.kung.shop.order.feign;

import io.kung.shop.bean.Product;
import io.kung.shop.bean.User;
import io.kung.shop.order.feign.fallback.ProductServiceFallBack;
import io.kung.shop.order.feign.fallback.factory.ProductServiceFallBackFactory;
import io.kung.shop.utils.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author kung
 * @Version 1.0.0
 */
//@FeignClient(value = "server-product", fallback = ProductServiceFallBack.class)
@FeignClient(value = "server-product", fallbackFactory = ProductServiceFallBackFactory.class)
public interface ProductService {

    /**
     * 获取商品信息
     */
    @GetMapping(value = "/product/get/{pid}")
    Product getProduct(@PathVariable("pid") Long pid);

    /**
     * 更新库存数量
     */
    @GetMapping(value = "/product/update_count/{pid}/{count}")
    Result<Integer> updateCount(@PathVariable("pid") Long pid, @PathVariable("count") Integer count);
}
