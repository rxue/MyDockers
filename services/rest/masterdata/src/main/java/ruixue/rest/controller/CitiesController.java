package ruixue.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ruixue.rest.entity.City;
import ruixue.rest.entity.Shop;
import ruixue.rest.repository.CitiesRepository;
import ruixue.rest.repository.ShopsRepository;

@CrossOrigin(origins = "*")
@RestController
public class CitiesController {
	@Autowired
	private CitiesRepository repository;
	@RequestMapping("/cities")
	public List<City> getShops() {
		return repository.findAll();
	}
}