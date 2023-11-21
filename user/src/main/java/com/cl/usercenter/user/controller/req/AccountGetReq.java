package com.cl.usercenter.user.controller.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountGetReq {
    @NotBlank(message = "【id】不能为空")
    private String id;
}
