package com.yanwuyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.sql.Connection;

@Configuration
public class RedisConfig {
    @Bean
    public <T> RedisTemplate<String,T> redisTemplate(RedisConnectionFactory redisConnectionFactory){
         RedisTemplate template=new RedisTemplate();
         template.setConnectionFactory(redisConnectionFactory);
         template.setKeySerializer(new StringRedisSerializer());
         template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
         return template;
    }
}
