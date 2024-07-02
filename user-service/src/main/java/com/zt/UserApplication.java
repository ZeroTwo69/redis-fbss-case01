package com.zt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/4-10:33
 * @Description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//禁用数据源
@EnableDiscoveryClient
@EnableFeignClients //开启feign
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
