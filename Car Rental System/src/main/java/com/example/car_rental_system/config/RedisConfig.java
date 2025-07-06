package com.example.car_rental_system.config;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class RedisConfig {
    public static RedisTemplate<String, String> createRedisTemplate() {
        // Create connection factory (default localhost:6379)
        LettuceConnectionFactory factory = new LettuceConnectionFactory();
        factory.afterPropertiesSet();

        // Create RedisTemplate with serializers
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // Set serializers
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }
}
