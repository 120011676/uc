package com.github.qq120011676.uc.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.qq120011676.uc.user.controller.req.*;
import com.github.qq120011676.uc.user.controller.resp.AccountGetResp;
import com.github.qq120011676.uc.user.controller.resp.AccountLoginNoAuthResp;
import com.github.qq120011676.uc.user.controller.resp.AccountLoginResp;
import com.github.qq120011676.uc.user.controller.resp.AccountPageResp;

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
