package com.rx.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<City> readAllCities() {
		return repository.findAll();
	}
	
	@PostMapping("")
	public City createCity(@RequestBody City city) {
		repository.save(city);
		return city;
	}
	
	@DeleteMapping("/{cityName}")
	public List<City> deleteCity(@PathVariable("cityName") String cityName) {
		return repository.deleteByCity(cityName);
	}
	
}