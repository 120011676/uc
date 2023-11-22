package com.github.qq120011676.uc.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.qq120011676.uc.user.controller.req.*;
import com.github.qq120011676.uc.user.controller.resp.AccountGetResp;
import com.github.qq120011676.uc.user.controller.resp.AccountLoginNoAuthResp;
import com.github.qq120011676.uc.user.controller.resp.AccountLoginResp;
import com.github.qq120011676.uc.user.controller.resp.AccountPageResp;
import com.github.qq120011676.uc.user.service.AccountExtendService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    @Resource
    private AccountExtendService accountExtendService;

    @PostMapping("page")
    public IPage<AccountPageResp> page(@RequestBody @Validated AccountPageReq req) {
        return accountExtendService.page(req);
    }

    @PostMapping("get")
    public AccountGetResp get(@RequestBody @Validated @Valid @NotNull AccountGetReq req) {
        return accountExtendService.get(req);
    }

    @PostMapping("addBatch")
    public void addBatch(@RequestBody @Validated @NotEmpty List<AccountAddBatchReq> req) {
        accountExtendService.addBatch(req);
    }

    @PostMapping("updatePassword")
    public void updatePassword(@RequestBody @Validated @NotNull UpdatePasswordReq req) {
        accountExtendService.updatePassword(req);
    }

    @PostMapping("updateEnableBatch")
    public void updateEnableBatch(@RequestBody @Validated @NotNull UpdateEnableBatchReq req) {
        accountExtendService.updateEnableBatch(req);
    }

    @RequestMapping("login")
    public AccountLoginResp login(@RequestBody @Validated @NotNull AccountLoginReq req) {
        return accountExtendService.login(req);
    }

    @RequestMapping("loginNoAuth")
    public AccountLoginNoAuthResp loginNoAuth(@RequestBody @Validated @NotNull AccountLoginNoAuthReq req) {
        return accountExtendService.loginNoAuth(req);
    }
}
