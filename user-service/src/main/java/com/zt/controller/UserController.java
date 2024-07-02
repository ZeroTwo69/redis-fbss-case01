package com.zt.controller;

import com.zt.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/4-10:36
 * @Description
 */
@RestController
@Slf4j
public class UserController {
    @Resource
    private SeckillService seckillService;
    @GetMapping("deductStockById")
    public ResponseEntity<String> deductStockById() {
        return seckillService.deductStockById().equals("成功")?
                ResponseEntity.ok("提交成功"):
                ResponseEntity.status(202)
                        .body("更新库存失败，可能是库存不足或其他原因。");
    }
}
