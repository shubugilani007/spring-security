package com.shubu.in.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubu.in.springsecurity.model.User;

/**
 * 
 * @author Shoaib
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}