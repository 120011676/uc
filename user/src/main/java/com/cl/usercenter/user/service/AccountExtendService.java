package com.cl.usercenter.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cl.usercenter.user.controller.req.*;
import com.cl.usercenter.user.controller.resp.AccountGetResp;
import com.cl.usercenter.user.controller.resp.AccountLoginNoAuthResp;
import com.cl.usercenter.user.controller.resp.AccountLoginResp;
import com.cl.usercenter.user.controller.resp.AccountPageResp;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AccountExtendService {
    IPage<AccountPageResp> page(AccountPageReq req);

    AccountGetResp get(AccountGetReq req);

    void addBatch(List<AccountAddBatchReq> req);

    void updatePassword(UpdatePasswordReq req);

    void updateEnableBatch(UpdateEnableBatchReq req);

    AccountLoginResp login(AccountLoginReq req);

    AccountLoginNoAuthResp loginNoAuth(AccountLoginNoAuthReq req);
}
