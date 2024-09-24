package com.miraijr.query_side.application.modules.account.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miraijr.query_side.application.modules.account.entities.AccountTokenEntity;

public interface AccountTokenRepository extends JpaRepository<AccountTokenEntity, Long> {
    Optional<AccountTokenEntity> getByAccessToken(String accessToken);
}
