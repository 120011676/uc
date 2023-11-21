package com.cl.usercenter.user.service;

import com.cl.usercenter.user.entity.AccountEntity;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class AccountServiceTest {
    @Resource
    private AccountService accountService;

    @Test
    public void insert() {
        AccountEntity account = new AccountEntity();
        account.setId("0");
        account.setUsername("15828395524");
        account.setPassword("123456");
        boolean bol = accountService.saveOrUpdate(account);
        Assert.isTrue(bol, "更新失败");
    }
}
