package com.example.socialtodogrinder.service;

import com.example.socialtodogrinder.persist.FeedEntity;
import com.example.socialtodogrinder.persist.FeedRepository;
import com.example.socialtodogrinder.persist.SupportEntity;
import com.example.socialtodogrinder.persist.SupportRepository;
import com.example.socialtodogrinder.persist.UserRepository;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportRepository supportRepository;
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Transactional
    public void pressSupportOnlyDB(){
        // 1 ~ 10_000 번의 유저들 중 임의의 1 명이 주키 아이디 5000 번의 글에 좋아요를 누른다.
        // 주키 번호 추첨
        Long randomUserId = random.nextLong(10000);

        // 5000번 피드 엔티티에 좋아요 개수 1개 추가하고, 서포트 정보를 서포트 테이블에 기록하기.
        Optional<FeedEntity> optionalFeedEntity = feedRepository.findById(5000L);
        if(optionalFeedEntity.isPresent()){
            FeedEntity feedEntity = optionalFeedEntity.get();
            Long supportNumber = feedEntity.getSupportNumber();
            supportNumber++;
            feedEntity.setSupportNumber(supportNumber);

            supportRepository.save(
                SupportEntity.builder()
                    .feedId(5000L)
                    .supportSentUserId(randomUserId)
                    .build()
            );
        }

    }

    @Transactional
    public void pressSupportDBandRedisAndAsync(){
        // 1 ~ 10_000 번의 유저들 중 임의의 1 명이 주키 아이디 5000 번의 글에 좋아요를 누른다.
        // 주키 번호 추첨
        Long randomUserId = random.nextLong(10000);

        // 5000번 피드가 아니라 레디스에 좋아요 기록하가..

        // support 테이블에 기록하가.
    }

    @Transactional
    public void pressSupportDBandRedisAndKafkaNoAsyncKafkaProducer(){
        // 1 ~ 10_000 번의 유저들 중 임의의 1 명이 주키 아이디 5000 번의 글에 좋아요를 누른다.
        // 주키 번호 추첨

        // 5000번 피드가 아니라 레디스에 좋아요 누르기.

        // support 테이블에 기록하는 것이 아니라, 카프카에 메시지만 보내기.
    }

    public void kafkaConsumer(){
        // 여기서 카프카의 메시지를 소비하면서 DB의 support 정보 테이블에 정보를 기록한다.
        // 단, 처리량을 조절해야 한다.
    }

}
