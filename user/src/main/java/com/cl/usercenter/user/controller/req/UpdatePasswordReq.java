package com.cl.usercenter.user.controller.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdatePasswordReq {
    @NotBlank(message = "【账号】不能为空")
    private String username;
    @NotBlank(message = "【密码】不能为空")
    private String password;
}
