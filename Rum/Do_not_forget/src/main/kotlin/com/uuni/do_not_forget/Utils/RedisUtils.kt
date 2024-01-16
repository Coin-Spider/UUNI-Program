package com.uuni.do_not_forget.Utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import kotlin.math.log

@Component
class RedisUtils {
    @Autowired lateinit var redisTemplate:StringRedisTemplate

    fun delete(key:String){
        println("${key} is been deleted")
        redisTemplate.delete(key)
    }
}