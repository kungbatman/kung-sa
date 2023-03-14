package io.kung.shop.predicate;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author kung
 * @Date 2023/3/7 14:40
 * @Version 1.0.0
 * @Description 接收配置文件中的参数
 */
@Data
public class NameRoutePredicateConfig implements Serializable {
    private static final long serialVersionUID = -3289515863427972825L;
    private String name;
}
