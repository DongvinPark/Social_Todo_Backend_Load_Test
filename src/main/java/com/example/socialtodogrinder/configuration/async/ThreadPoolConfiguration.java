package com.example.socialtodogrinder.configuration.async;

import java.util.concurrent.Executor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfiguration extends AsyncConfigurerSupport {

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        int n = Runtime.getRuntime().availableProcessors();

        executor.setCorePoolSize(3*n);
        executor.setMaxPoolSize(3*n);
        executor.setQueueCapacity(15_000);
        executor.setThreadNamePrefix("Async Thread -");
        executor.initialize();
        return executor;
    }


    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }

}
