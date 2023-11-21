package com.cl.usercenter.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("account")
public class AccountEntity {
    private String id;
    private String username;
    private String password;
    private LocalDateTime createDatetime;
    private LocalDateTime updateDatetime;
    private Boolean enable;
}
