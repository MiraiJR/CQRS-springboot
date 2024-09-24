package com.miraijr.query_side.application.modules.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miraijr.query_side.application.modules.user.entities.UserAddressEntity;

public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {

}
