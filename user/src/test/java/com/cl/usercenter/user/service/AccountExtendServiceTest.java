package com.cl.usercenter.user.service;

import com.cl.usercenter.user.controller.req.AccountGetReq;
import com.cl.usercenter.user.controller.resp.AccountGetResp;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class AccountExtendServiceTest {
    @Resource
    private AccountExtendService accountExtendService;

    @Test
    public void get() {
        AccountGetReq req = new AccountGetReq();
        req.setId("1");
        AccountGetResp resp = accountExtendService.get(req);
        Assert.isNull(resp, "错误");
    }

}
