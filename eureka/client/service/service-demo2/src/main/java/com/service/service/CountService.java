package com.service.service;

import com.service.entity.Account;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/12 20:47
 */
public interface CountService {
    Account getOne(int id);

    void update(Account account);
}
