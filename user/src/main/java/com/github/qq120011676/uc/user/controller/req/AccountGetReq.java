package com.github.qq120011676.uc.user.controller.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountGetReq {
    @NotBlank(message = "【id】不能为空")
    private String id;
}
