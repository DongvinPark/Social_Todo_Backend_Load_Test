package com.example.socialtodogrinder.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
@RequiredArgsConstructor
public class RedisConfiguration {
    @Value("${aws.redis.url}")
    private String redisURL;

    @Value("${aws.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisURL, port);
        factory.afterPropertiesSet();
        return factory;
    }



    //유저의 jwt 토큰, 응원 및 잔소리 개수, 응원 및 잔소리 이벤트 처리용 메시지, 특정 유저가 팔로우한 다른 유저들 리스트
    // 를 저장해 둘 레디스 템플릿을 빈으로 만들어준다.
    //레디스 템플릿 객체를 빈으로부터 주입 받아서 생성 할 때, 현재 정의한
    //빈을 우선적으로 주입받을 수 있도록 @Primary 를 붙여준다.
    @Bean
    @Primary
    public RedisTemplate<String, String> makeUserJwtRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        //템플릿을 만들어서 설정값을 붙여준다.
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

        //레디스 템플릿은 레디스 오퍼레이션 기능을 추상화하여 제공하는 클래스다.
        //오펴레이션 기능이 작동하기 위해서는 연결 url(==AWS의 경우 엔드포인트 문자열) 등의 세부 정보를 설정해줘야 한다.
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //시리얼라리저를 설정해줘야 한다. 둘다 스트링이다.
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

}
