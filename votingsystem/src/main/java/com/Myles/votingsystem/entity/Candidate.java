package com.Myles.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidates")
public class Candidate {
	
	public Candidate() {
		super();
	}

	@Id
	@Column(name="id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="candidate_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Column(name="numberOfVotes")
	private Integer numberOfVotes;

	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	

}
