package io.kung.shop.filter;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author kung
 * @Date 2023/3/7 15:19
 * @Version 1.0.0
 * @Description 接收配置参数
 */
@Data
public class GrayscaleGatewayFilterConfig implements Serializable {
    private static final long serialVersionUID = 983019309000445082L;
    private boolean grayscale;
}
