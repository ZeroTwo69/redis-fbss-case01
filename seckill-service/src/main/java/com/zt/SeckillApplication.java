package com.zt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/4-10:26
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient // 注册到注册中心
public class SeckillApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
}
