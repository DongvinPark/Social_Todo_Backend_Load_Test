package com.example.socialtodogrinder.service;

import com.example.socialtodogrinder.persist.UserEntity;
import com.example.socialtodogrinder.persist.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    //@Async
    public void initUserDB(){
        // 1번부터 10000번의 유저만 시험 삼아서 만들어본다.
        for(int i=9001; i<=10000; i++){
            userRepository.save(
                UserEntity.builder()
                    .nickname("user No : " + i)
                    .build()
            );
        }
    }

}
