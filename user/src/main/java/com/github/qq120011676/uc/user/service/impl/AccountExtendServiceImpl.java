package com.github.qq120011676.uc.user.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.github.qq120011676.uc.user.controller.req.*;
import com.github.qq120011676.uc.user.controller.resp.AccountGetResp;
import com.github.qq120011676.uc.user.controller.resp.AccountLoginNoAuthResp;
import com.github.qq120011676.uc.user.controller.resp.AccountLoginResp;
import com.github.qq120011676.uc.user.controller.resp.AccountPageResp;
import com.github.qq120011676.uc.user.entity.AccountEntity;
import com.github.qq120011676.uc.user.service.AccountExtendService;
import com.github.qq120011676.uc.user.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AccountExtendServiceImpl implements AccountExtendService {
    @Resource
    private AccountService accountService;

    @Override
    public IPage<AccountPageResp> page(AccountPageReq req) {
        Page<AccountEntity> page = PageDTO.of(req.getCurrent(), req.getSize());
        IPage<AccountEntity> iPage = accountService.lambdaQuery()
                .page(page);
        IPage<AccountPageResp> respIPage = PageDTO.of(iPage.getCurrent(), iPage.getSize(), iPage.getTotal());
        return respIPage.setRecords(iPage.getRecords().stream()
                .map(o -> {
                    AccountPageResp resp = new AccountPageResp();
                    BeanUtils.copyProperties(o, resp);
                    return resp;
                }).collect(Collectors.toList()));
    }

    @Override
    public AccountGetResp get(AccountGetReq req) {
        AccountEntity account = accountService.getById(req.getId());
        if (Objects.isNull(account)) {
            throw new RuntimeException("数据不存在");
        }
        AccountGetResp resp = new AccountGetResp();
        BeanUtils.copyProperties(account, resp);
        return resp;
    }

    @Override
    public void addBatch(List<AccountAddBatchReq> req) {
        accountService.saveOrUpdateBatch(req.stream()
                .map(o -> {
                    AccountEntity account = new AccountEntity();
                    BeanUtils.copyProperties(o, account);
                    String m = sign(o.getUsername(), o.getPassword());
                    account.setPassword(m);
                    return account;
                })
                .collect(Collectors.toList()));
    }

    @Override
    public void updatePassword(UpdatePasswordReq req) {
        AccountEntity account = accountService.lambdaQuery()
                .eq(AccountEntity::getUsername, req.getUsername())
                .one();
        if (Objects.isNull(account)) {
            throw new RuntimeException("账号不存在");
        }
        String m = sign(req.getUsername(), req.getPassword());
        accountService.lambdaUpdate()
                .eq(AccountEntity::getUsername, req.getUsername())
                .set(AccountEntity::getPassword, m)
                .update();
    }

    @Override
    public void updateEnableBatch(UpdateEnableBatchReq req) {
        accountService.lambdaUpdate()
                .in(AccountEntity::getId, req.getIds())
                .set(AccountEntity::getEnable, req.getEnable())
                .update();
    }

    @Override
    public AccountLoginResp login(AccountLoginReq req) {
        AccountEntity account = get(req.getUsername());
        String m = sign(account.getUsername(), account.getPassword());
        if (!Objects.equals(req.getPassword(), m)) {
            throw new RuntimeException("密码不正确");
        }
        AccountLoginResp resp = new AccountLoginResp();
        resp.setId(account.getId());
        resp.setUsername(account.getUsername());
        return resp;
    }

    @Override
    public AccountLoginNoAuthResp loginNoAuth(AccountLoginNoAuthReq req) {
        AccountEntity account = get(req.getUsername());
        AccountLoginNoAuthResp resp = new AccountLoginNoAuthResp();
        resp.setId(account.getId());
        resp.setUsername(account.getUsername());
        return resp;
    }

    public AccountEntity get(String username) {
        AccountEntity account = accountService.lambdaQuery()
                .eq(AccountEntity::getUsername, username)
                .one();
        if (Objects.isNull(account)) {
            throw new RuntimeException("账号不存在");
        }
        if (!Objects.equals(Boolean.TRUE, account.getEnable())) {
            throw new RuntimeException("账号已禁用");
        }
        return account;
    }

    private String sign(String username, String password) {
        return DigestUtil.sha256Hex(MessageFormat.format("{0}{1}",
                username,
                password));
    }
}
