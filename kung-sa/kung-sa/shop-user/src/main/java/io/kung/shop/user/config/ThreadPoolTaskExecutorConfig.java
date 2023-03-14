package io.kung.shop.user.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Author kung
 * @Date 2023/3/8 11:08
 * @Version 1.0.0
 * @Description Sleuth异步线程池配置
 */
@Configuration
@EnableAutoConfiguration
public class ThreadPoolTaskExecutorConfig extends AsyncConfigurerSupport {

    @Autowired
    private BeanFactory beanFactory;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("trace-thread-");
        executor.initialize();
//        return executor; // 新的TraceID和SpanID
        return new LazyTraceExecutor(this.beanFactory, executor); // 重新创建Span
    }
}
