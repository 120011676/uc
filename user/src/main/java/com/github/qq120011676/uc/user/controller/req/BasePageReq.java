package com.github.qq120011676.uc.user.controller.req;

import lombok.Data;

@Data
public class BasePageReq {
    private Long current = 1L;
    private Long size = 10L;
}
