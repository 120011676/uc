package com.github.qq120011676.uc.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("account")
public class AccountEntity extends BaseEntity {
    private String id;
    private String username;
    private String password;
}
