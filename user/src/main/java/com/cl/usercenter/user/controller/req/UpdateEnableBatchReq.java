package com.cl.usercenter.user.controller.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UpdateEnableBatchReq {
    @NotEmpty(message = "【账号id集合】不能为空")
    private List<String> ids;
    @NotNull(message = "【状态】不能为空")
    private Boolean enable;
}
