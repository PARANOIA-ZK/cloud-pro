package com.service.dao;

import com.service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author PARANOIA_ZK
 * @date 2018/3/12 20:31
 */
public interface AccountRepository extends JpaRepository<Account,Integer> {

}
