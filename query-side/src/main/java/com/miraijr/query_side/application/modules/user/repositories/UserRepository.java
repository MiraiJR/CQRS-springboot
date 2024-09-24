package com.miraijr.query_side.application.modules.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miraijr.query_side.application.modules.user.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
