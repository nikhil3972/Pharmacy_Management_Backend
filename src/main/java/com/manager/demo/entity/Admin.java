package com.manager.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {

	@Id
	int id;
	String email;
	String password;
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;
	
	Admin(){}

	public Admin(int id, String email, String password, String created_by, String modified_by, Date created_ts,
			Date modified_ts) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.created_by = created_by;
		this.modified_by = modified_by;
		this.created_ts = created_ts;
		this.modified_ts = modified_ts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getCreated_ts() {
		return created_ts;
	}

	public void setCreated_ts(Date created_ts) {
		this.created_ts = created_ts;
	}

	public Date getModified_ts() {
		return modified_ts;
	}

	public void setModified_ts(Date modified_ts) {
		this.modified_ts = modified_ts;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + password + ", created_by=" + created_by
				+ ", modified_by=" + modified_by + ", created_ts=" + created_ts + ", modified_ts=" + modified_ts + "]";
	}
}
