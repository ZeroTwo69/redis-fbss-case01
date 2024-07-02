package com.zt.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/3-9:29
 * @Description redisson配置类
 */
//redisson配置类
@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config(); //创建配置
        config.useSingleServer() //redis单机版配置
                .setAddress("redis://localhost:6379");//地址
//                .setPassword("123456")
        return Redisson.create(config); //初始化redisson配置
    }

}
