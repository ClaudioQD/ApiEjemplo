package com.pruebaFinal.ClaudioQuijada.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaFinal.ClaudioQuijada.models.Show;


public interface ShowRepository extends JpaRepository<Show, Long>{

	List<Show> findAll();
}
