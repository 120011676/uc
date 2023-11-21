package com.cl.usercenter.user.controller.resp;

import com.cl.usercenter.user.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountPageResp extends BaseEntity {
    private String id;
    private String username;
}
