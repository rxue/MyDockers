package com.rx.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.rx.entity.City;
import com.rx.repository.CityRepository;
import com.rx.rest.exception.ResourceExistingException;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private CityRepository citiesRepository;
	@Override
	public List<City> getAllCities() {
		return citiesRepository.findAll();
	}
	
	@Override
	public City getCityById(Integer cityId) throws ResourceNotFoundException {
		return citiesRepository.findById(cityId)
				//.orElseThrow(() -> new ResourceNotFoundException("City with ID " + cityId + " does not exist"));
				.orElseThrow(ResourceNotFoundException::new);

	}

	@Override
	public void addCity(City city) throws ResourceExistingException {
		String country = city.getCountry();
		String cityName = city.getCity();
		if (citiesRepository.findByCountryAndCity(country, cityName).isPresent())
			throw new ResourceExistingException("The city " + city + " exists");
		citiesRepository.save(city);
	}

}
