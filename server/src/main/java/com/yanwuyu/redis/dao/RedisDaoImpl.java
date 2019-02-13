package com.yanwuyu.redis.dao;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class RedisDaoImpl {
@Autowired
    private RedisTemplate<Serializable,Serializable> redisTemplate;
}
