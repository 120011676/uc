package com.github.qq120011676.uc.user.controller.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountPageReq extends BasePageReq{
    private String username;
}
