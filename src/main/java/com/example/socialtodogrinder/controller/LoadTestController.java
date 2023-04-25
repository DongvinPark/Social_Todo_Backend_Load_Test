package com.example.socialtodogrinder.controller;

import com.example.socialtodogrinder.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoadTestController {

    private final SupportService supportService;

    @PostMapping("/test/database")
    public void pressSupportOnlyDB(){

    }

    @PostMapping("/test/redis/async")
    public void pressSupportDBRedisAsync(){
        
    }

}
