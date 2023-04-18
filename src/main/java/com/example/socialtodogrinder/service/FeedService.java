package com.example.socialtodogrinder.service;

import com.example.socialtodogrinder.persist.FeedEntity;
import com.example.socialtodogrinder.persist.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    @Transactional
    //@Async
    public void initFeedDb(){
        // 시험 삼아서 100개의 게시글만 만들어본다.
        for(int i=9001; i<=10000; i++){
            feedRepository.save(
                FeedEntity.builder()
                    .content("feed content No : " + i)
                    .supportNumber(0L)
                    .build()
            );
        }
    }

}
