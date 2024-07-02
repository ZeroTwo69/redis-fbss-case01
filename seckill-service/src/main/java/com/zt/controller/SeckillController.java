package com.zt.controller;

import com.zt.bean.Seckill;
import com.zt.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/4-10:25
 * @Description
 */
@RestController
@Slf4j
public class SeckillController {

    @Resource
    private SeckillService seckillService;
    @GetMapping("deductStockById")
    public ResponseEntity<String> deductStockById(){
        return seckillService.deductStockById(1,1) ?
                ResponseEntity.ok("成功") :
                ResponseEntity.status(202)
                        .body("更新库存失败，可能是库存不足或其他原因。");
    }

    @PutMapping("updateStockById")
    public ResponseEntity<String> updateStockById(Integer sid , Integer deductQuantity){
        return seckillService.updateStockById(sid,deductQuantity)?
                ResponseEntity.ok("成功"):
                ResponseEntity.status(202)
                        .body("更新库存失败，可能是参数不正确或其他原因。");
    }

    @GetMapping("getSeckillById")
    public ResponseEntity<Seckill> getSeckillById(Integer sid){
        return ResponseEntity.ok(seckillService.getSeckillById(sid));
    }
}
