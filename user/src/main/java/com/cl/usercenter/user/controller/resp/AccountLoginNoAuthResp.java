package com.cl.usercenter.user.controller.resp;

import lombok.Data;

@Data
public class AccountLoginNoAuthResp {
    private String id;
    private String username;
    private Boolean enable;
}
