package com.example.socialtodogrinder.configuration.async;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

@Slf4j
public class CustomAsyncExceptionHandler
    implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(
        Throwable throwable, Method method, Object... obj) {

        log.error("@Async 예외 메시지 - " + throwable.getMessage());
        log.error("@Async 예외 발생한 메서드 이름 - " + method.getName());
        for (Object param : obj) {
            log.error("@Async 관련 예외 파라미터 값 - " + param);
        }
    }

}
