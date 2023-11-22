package com.github.qq120011676.uc.user.service;

import com.github.qq120011676.uc.user.controller.req.AccountGetReq;
import com.github.qq120011676.uc.user.controller.resp.AccountGetResp;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Objects;

@SpringBootTest
public class AccountExtendServiceTest {
    @Resource
    private AccountExtendService accountExtendService;

    @Test
    public void get() {
        AccountGetReq req = new AccountGetReq();
        req.setId("1");
        try {
            AccountGetResp resp = accountExtendService.get(req);
            Assert.isNull(resp, "错误");
        } catch (Exception e) {
            Assert.isTrue(Objects.equals("数据不存在", e.getMessage()), e.getMessage());
        }
    }

}
