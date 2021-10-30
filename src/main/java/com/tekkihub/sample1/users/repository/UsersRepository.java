package com.tekkihub.sample1.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekkihub.sample1.users.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
