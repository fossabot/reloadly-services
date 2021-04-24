package com.reloadly.account.repository;

import com.reloadly.account.entity.AccountBalanceEntity;
import com.reloadly.account.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountBalanceRepository extends CrudRepository<AccountBalanceEntity, Long> {
    Optional<AccountBalanceEntity> findByAcctBalanceUid(String acctBalanceUid);
}