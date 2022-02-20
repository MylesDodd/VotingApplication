package com.Myles.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Myles.votingsystem.entity.Auditor;

public interface AuditorRepo extends JpaRepository<Auditor, Integer> {
	
	public Auditor findByName(String name);
}
