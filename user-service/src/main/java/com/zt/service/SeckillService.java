package com.zt.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/4-10:25
 * @Description
 */
@Service
@FeignClient(name = "seckill-service")
public interface SeckillService {
    @GetMapping("deductStockById")
    public String deductStockById();
}
