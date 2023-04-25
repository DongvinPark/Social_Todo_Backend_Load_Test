package com.example.socialtodogrinder.controller;

import com.example.socialtodogrinder.service.FeedService;
import com.example.socialtodogrinder.service.SupportService;
import com.example.socialtodogrinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DatabaseInitController {

    private final FeedService feedService;
    private final UserService userService;
    private final SupportService supportService;

    /*@PostMapping("/init/feeds")
    public void initFeed(){
        feedService.initFeedDb();
    }

    @PostMapping("/init/users")
    public void initUser(){
        userService.initUserDB();
    }*/

    @PostMapping("/init/redis")
    public void initRedis(){
        supportService.initRedis();
    }

}
