package com.manager.demo.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Disease")
public class Disease {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	String info;
	
	@OneToMany(targetEntity = Disease_Type.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "disease_fk", referencedColumnName = "id")
	List<Disease_Type> disease_type;
	
	String created_by;
	String modified_by;
	Date created_ts;
	Date modified_ts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<Disease_Type> getDisease_type() {
		return disease_type;
	}
	public void setDisease_type(List<Disease_Type> disease_type) {
		this.disease_type = disease_type;
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
		return "Disease [id=" + id + ", name=" + name + ", info=" + info + ", disease_type=" + disease_type
				+ ", created_by=" + created_by + ", modified_by=" + modified_by + ", created_ts=" + created_ts
				+ ", modified_ts=" + modified_ts + "]";
	}
}
