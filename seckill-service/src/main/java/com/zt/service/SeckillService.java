package com.zt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.bean.Seckill;
import org.springframework.stereotype.Service;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/4-10:11
 * @Description
 */
@Service
public interface SeckillService extends IService<Seckill> {
    boolean deductStockById(Integer sid, Integer deductQuantity);

    boolean updateStockById(Integer sid, Integer updateQuantity);

    Seckill getSeckillById(Integer sid);
}
