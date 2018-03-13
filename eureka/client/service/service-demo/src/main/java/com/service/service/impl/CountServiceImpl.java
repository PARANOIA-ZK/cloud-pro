package com.service.service.impl;

import com.service.dao.AccountRepository;
import com.service.entity.Account;
import com.service.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/12 20:48
 */
@Service
public class CountServiceImpl implements CountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account getOne(int id) {
        return accountRepository.getOne(id);
    }

    @Override
    public void update(Account account) {
        accountRepository.saveAndFlush(account);
    }
}
