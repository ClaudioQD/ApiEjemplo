package com.pruebaFinal.ClaudioQuijada.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaFinal.ClaudioQuijada.models.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>{

	List<Role> findAll();
	
	List<Role> findByName(String name);
}
