package com.minds.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.minds.bean.CustomUser;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, String> {

	@Query("from CustomUser where username = :username")
	CustomUser findByUsername(@Param("username") String username);
}