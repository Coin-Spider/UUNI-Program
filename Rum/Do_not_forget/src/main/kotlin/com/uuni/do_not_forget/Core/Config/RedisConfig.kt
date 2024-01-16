package com.uuni.do_not_forget.Core.Config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig{
    /**
     * RedisTemplate配置
     * @param connectionFactory
     * @return
     */
    @Bean
    fun redisTemplate(connectionFactory: LettuceConnectionFactory?): RedisTemplate<String, Any> {
        // 配置redisTemplate
        val redisTemplate = RedisTemplate<String, Any>()
        redisTemplate.connectionFactory = connectionFactory
        redisTemplate.keySerializer = StringRedisSerializer() //key序列化
        redisTemplate.valueSerializer = GenericJackson2JsonRedisSerializer() //value序列化
        redisTemplate.afterPropertiesSet()
        return redisTemplate
    }
}
