package io.kung.shop.predicate;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author kung
 * @Date 2023/3/7 14:42
 * @Version 1.0.0
 * @Description 自定义断言功能
 */
//@Component
public class NameRoutePredicateFactory extends AbstractRoutePredicateFactory<NameRoutePredicateConfig> {
    public NameRoutePredicateFactory() {
        super(NameRoutePredicateConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(NameRoutePredicateConfig config) {
        return (serverWebExchange -> {
            String name = serverWebExchange.getRequest().getQueryParams().getFirst("name");
            if (StringUtils.isEmpty(name)) {
                name = "";
            }
            return name.equals(config.getName());
        });
    }

    @Override
    public List<String> shortcutFieldOrder(){
        return Arrays.asList("name");
    }

}
