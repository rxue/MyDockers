package com.rx.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rx.rest.dao.CitiesRepository;
import com.rx.rest.dao.ShopsRepository;

import ruixue.rest.entity.City;
import ruixue.rest.entity.Shop;

@CrossOrigin(origins = "*")
@RestController
public class CitiesController {
	@Autowired
	private CitiesRepository repository;
	@RequestMapping("/cities")
	public List<City> getShops() {
		System.out.println("DEBUG");
		return repository.findAll();
	}
}