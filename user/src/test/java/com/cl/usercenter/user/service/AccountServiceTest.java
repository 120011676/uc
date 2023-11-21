package com.cl.usercenter.user.service;

import com.cl.usercenter.user.entity.AccountEntity;
import com.cl.usercenter.user.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.UUID;

@SpringBootTest
public class AccountServiceTest {
    @Resource
    private AccountService accountService;

    @Test
    public void insert() {
        AccountEntity account = new AccountEntity();
        account.setId(UUID.randomUUID().toString());
        account.setUsername("15828395524");
        account.setPassword("123456");
        boolean bol = accountService.saveOrUpdate(account);
        Assert.isTrue(bol, "更新失败");
    }
}
