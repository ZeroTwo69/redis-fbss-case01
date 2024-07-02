package com.zt.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 02
 * @version 1.0
 * @Date 2024/6/4-10:04
 * @Description
 */
@Data
@Component
@TableName("seckill")
public class Seckill implements Serializable {
    @TableId(value = "sid",type = IdType.AUTO)
    private Integer sid;
    private Integer stock;
}
