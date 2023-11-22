package com.github.qq120011676.uc.user.controller.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountLoginReq {
    @NotBlank(message = "【账号】不能为空")
    private String username;
    @NotBlank(message = "【密码】不能为空")
    private String password;
}
