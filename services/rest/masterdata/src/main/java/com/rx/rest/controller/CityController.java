package com.rx.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rx.entity.City;
import com.rx.repository.CityRepository;
import com.rx.rest.service.CityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cities")
public class CityController {
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CityService cityService;
	
	@PostMapping("")
	@ResponseStatus(value=HttpStatus.CREATED)
	public City createCity(@Valid @RequestBody City city) {
		cityService.addCity(city);
		return city;
	}
	
	@GetMapping("")
	public List<City> readAllCities() {
		return cityService.getAllCities();
	}
	
	@GetMapping("/{cityId}")
	public City readCity(@PathVariable Integer cityId) {
		return cityService.getCityById(cityId);
	}
	
	@PutMapping("/{cityName}")
	public void updateCity(@PathVariable("cityName") String cityName, 
			@RequestBody City city) {
		cityRepository.save(city);
	}
	
	@DeleteMapping("/{cityName}")
	public void deleteCity(@PathVariable("cityName") String cityName) {
		cityRepository.deleteByCity(cityName);
	}
	
}