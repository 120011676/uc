package com.github.qq120011676.uc.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.qq120011676.uc.user.entity.AccountEntity;
import com.github.qq120011676.uc.user.mapper.AccountMapper;
import com.github.qq120011676.uc.user.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountEntity> implements AccountService {
}
