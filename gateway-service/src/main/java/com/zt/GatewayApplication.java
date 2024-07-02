package com.zt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/5/29-9:34
 * @Description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // 禁用数据源
@EnableDiscoveryClient // 开启服务注册与发现
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
