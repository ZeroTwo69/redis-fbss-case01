package com.zt.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@TableName("user")
public class User implements Serializable {
    @TableId(value = "uid",type = IdType.AUTO)
    private Integer uid;
    private String userName="成龙";
    private String password="123456";
    private String role="教员";
    private String phone="110";

}
