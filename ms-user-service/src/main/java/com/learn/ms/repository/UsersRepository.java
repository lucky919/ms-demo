package com.learn.ms.repository;

import org.springframework.data.repository.CrudRepository;

import com.learn.ms.domain.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);
	
}
