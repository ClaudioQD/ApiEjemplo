package com.pruebaFinal.ClaudioQuijada.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaFinal.ClaudioQuijada.dao.ShowRepository;
import com.pruebaFinal.ClaudioQuijada.models.Show;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepository;
	
		
	//Reade one by id
	public Show findUserById(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}
	
	//Reade all
	public List<Show> findAllShows(){
		return showRepository.findAll();
		
	}
		
	
	//create - save
	public void saveShow(Show show) {
		showRepository.save(show);
		
	}	
	
	//update
	public void updateShow(Show show) {
		showRepository.save(show);
	}	
	
	//delete
	
	public void deleteShow(Long id) {
		showRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
