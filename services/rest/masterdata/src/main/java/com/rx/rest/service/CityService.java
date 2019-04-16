package com.rx.rest.service;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.rx.entity.City;
import com.rx.rest.exception.ResourceExistingException;
public interface CityService {
	public void addCity(City city) throws ResourceExistingException;
	public List<City> getAllCities(); 
	public City getCityById(Integer cityId) throws ResourceNotFoundException;
	
}
