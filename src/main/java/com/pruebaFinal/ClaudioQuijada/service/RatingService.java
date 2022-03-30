package com.pruebaFinal.ClaudioQuijada.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaFinal.ClaudioQuijada.dao.RatingRepository;
import com.pruebaFinal.ClaudioQuijada.models.Rating;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	public List<Rating> findAllRating() {
		return ratingRepository.findAll();

	}

	// revisar el metodo porque me derivo al metodo optional
	// y nose porque
	// Reade one by id
	public Rating findRatingById(Long id) {
		Optional<Rating> optionalRating = ratingRepository.findById(id);
		if (optionalRating.isPresent()) {
			return optionalRating.get();
		} else {
			return null;
		}
	}
	
	
	//save rating
	public void addRating(Rating rating) {
		ratingRepository.save(rating);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
