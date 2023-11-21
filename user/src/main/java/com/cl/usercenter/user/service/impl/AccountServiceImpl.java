package com.cl.usercenter.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.usercenter.user.entity.AccountEntity;
import com.cl.usercenter.user.mapper.AccountMapper;
import com.cl.usercenter.user.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountEntity> implements AccountService {
}
