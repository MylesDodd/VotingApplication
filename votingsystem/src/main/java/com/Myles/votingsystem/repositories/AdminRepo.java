package com.Myles.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Myles.votingsystem.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByName(String name);
}
