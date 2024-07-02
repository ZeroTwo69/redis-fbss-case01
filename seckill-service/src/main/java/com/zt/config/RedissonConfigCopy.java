package com.zt.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/3-9:29
 * @Description
 */
//@Configuration
public class RedissonConfigCopy {
    /**
     * 配置Redisson
     * @return RedissonClient
     */
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://localhost:6379"); // 设置redis地址
               // .setPassword("123456"); // 如果有密码
        return Redisson.create(config); // 返回RedissonClient对象
    }
}
