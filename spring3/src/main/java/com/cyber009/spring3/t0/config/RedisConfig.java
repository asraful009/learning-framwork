package com.cyber009.spring3.t0.config;

import com.cyber009.spring3.t0.dto.instance.InstanceWisePermissionDto;
import com.cyber009.spring3.t0.entity.InstanceWisePermission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.UUID;

//@Configuration
public class RedisConfig {
//    @Bean
//    public RedisConnectionFactory redisConnectionFactoryDBForInstancePermission() {
//        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
//        lettuceConnectionFactory.setDatabase(10);
//        return lettuceConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate<UUID, InstanceWisePermissionDto> redisTemplateForInstancePermission(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<UUID, InstanceWisePermissionDto> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactoryDBForInstancePermission());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        return redisTemplate;
//    }
}
