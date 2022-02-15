package com.Myles.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Myles.votingsystem.entity.Candidate;

@Repository
public interface CadidateRepo extends JpaRepository<Candidate, Integer> {

}
