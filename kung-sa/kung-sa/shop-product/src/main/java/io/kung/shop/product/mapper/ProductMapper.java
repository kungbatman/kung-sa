package io.kung.shop.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.kung.shop.bean.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author kung
 * @Version 1.0.0
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 扣减商品库存
     */
    int updateProductStockById(@Param("count") Integer count, @Param("id") Long id);
}
