package com.pruebaFinal.ClaudioQuijada.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaFinal.ClaudioQuijada.models.Rating;

public interface RatingRepository  extends JpaRepository<Rating, Long>{

	List<Rating> findAll();
}
