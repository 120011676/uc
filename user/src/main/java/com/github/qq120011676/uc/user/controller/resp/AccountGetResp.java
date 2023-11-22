package com.github.qq120011676.uc.user.controller.resp;

import com.github.qq120011676.uc.user.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountGetResp extends BaseEntity {
    private String id;
    private String username;
}
