package com.Myles.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//allows access to the cadidate database and creates association
import com.Myles.votingsystem.entity.Candidate;

@Repository
public interface CadidateRepo extends JpaRepository<Candidate, Integer> {
	
	public Candidate findById(long id);

}
