package com.rx.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rx.entity.City;
import com.rx.rest.dao.CitiesRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cities")
public class CitiesController {
	@Autowired
	private CitiesRepository repository;
	
	@GetMapping("")
	public List<City> getShops() {
		return repository.findAll();
	}
	
	@PostMapping("")
	public City createShop(City city) {
		repository.save(city);
		return city;
	}
	
}