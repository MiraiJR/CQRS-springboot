package com.miraijr.query_side.application.modules.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miraijr.query_side.application.modules.account.entities.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
