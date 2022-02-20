package com.Myles.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auditors")
public class Auditor {
	
	@Id
	@Column(name="id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="auditor_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="password")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name="user_type")
	private String userType;

	public String getUserGroup() {
		return userType;
	}

	public void setUserGroup(String userGroup) {
		this.userType = userGroup;
	}

	public Auditor(Long id, String name, String userGroup, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.userType = userGroup;
	}
	
	

}
