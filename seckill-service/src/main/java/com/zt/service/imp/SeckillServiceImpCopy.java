package com.zt.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.bean.Seckill;
import com.zt.mapper.SeckillMapper;
import com.zt.service.SeckillService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/4-10:12
 * @Description
 */
//@Service
public class SeckillServiceImpCopy extends ServiceImpl<SeckillMapper, Seckill> implements SeckillService {

    @Resource
    private RedissonClient redissonClient; //redisson客户端

    private static final String LOCK_KEY = "product_lock:"; //锁的key


    /**
     * 阻塞型锁
     * @param sid 订单id
     * @param deductQuantity 购买数量
     * @return 购买成功 返回 true 否则返回 false
     */
    @Override
    public boolean deductStockById(Integer sid, Integer deductQuantity) {
        //1，创建锁实例
        RLock redissonLock = redissonClient.getLock(LOCK_KEY + sid);
        try {
            //2.获取锁 并设置锁过期时间 5秒 若业务执行时间超过5秒 则锁自动续期
            redissonLock.lock(5, TimeUnit.SECONDS); //获取锁
            return deductStock(sid, deductQuantity); //3.执行业务逻辑
        }finally {
            redissonLock.unlock(); //4.释放锁
        }
    }




    /**
     * 非阻塞型锁
     * @param sid 订单id
     * @param deductQuantity 购买数量
     * @return 购买成功 返回 true 否则返回 false
     */
//    @Override
//    public boolean deductStockById(Integer sid, Integer deductQuantity) {
//        RLock redissonLock = redissonClient.getLock(LOCK_KEY + sid); //创建锁实例
//            //获取锁 并设置锁过期时间 5秒 若业务执行时间超过5秒 则锁自动续期
//            try {
//                boolean tryLock = redissonLock.tryLock(10,5, TimeUnit.SECONDS); //获取锁
//                if (!tryLock){
//                    return false; //获取锁失败
//                }
//                return deductStock(sid, deductQuantity); //执行业务逻辑
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }finally {
//                redissonLock.unlock(); //释放锁
//            }
//    }



//    /**
//     * 一人一单购买
//     * @param sid 订单id
//     * @param deductQuantity 购买数量
//     * @return 购买成功 返回 true 否则返回 false
//     */
//    @Override
//    public boolean deductStockById(Integer sid, Integer deductQuantity) {
//       return deductStock(sid, deductQuantity);
//    }



    /**
     * 业务代码
     * @param sid 订单id
     * @param deductQuantity 购买数量
     * @return 购买成功 返回 true 否则返回 false
     */
    private boolean deductStock(Integer sid, Integer deductQuantity) {
        // 查询当前库存
        Seckill seckill = this.baseMapper.selectById(sid);
        if (seckill == null) {
            // 商品不存在处理逻辑
            throw new RuntimeException("商品不存在");
        }
        // 检查库存是否足够
        if (seckill.getStock() <= 0) {
            // 库存不足处理逻辑
            throw new RuntimeException("库存不足");
        }
        // 更新库存
        UpdateWrapper<Seckill> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("sid", sid)
                .setSql("stock = stock - " + deductQuantity); // 动态SQL直接减去提交的数量
        return this.update(updateWrapper);
    }


    /**
     * 更新库存
     * @param sid 订单id
     * @param updateQuantity 更新数量
     * @return 更新成功 返回 true 否则返回 false
     */
    @Override
    public boolean updateStockById(Integer sid, Integer updateQuantity) {
        UpdateWrapper<Seckill> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("sid", sid).set("stock", updateQuantity);
        return this.update(updateWrapper);
    }
    /**
     * 根据id查询商品
     * @param sid 订单id
     * @return 商品信息
     */
    @Override
    public Seckill getSeckillById(Integer sid){
        return this.getOne(new QueryWrapper<Seckill>().eq("sid", sid));
    }


}
