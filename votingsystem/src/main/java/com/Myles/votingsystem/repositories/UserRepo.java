package com.Myles.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Myles.votingsystem.entity.User;
//allows access to the user database and creates association
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByName(String name);
	
}
