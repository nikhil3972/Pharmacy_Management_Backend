package com.manager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.demo.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
