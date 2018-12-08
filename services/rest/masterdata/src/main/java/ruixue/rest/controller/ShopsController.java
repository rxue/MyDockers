package ruixue.rest.controller;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ruixue.rest.entity.Shop;
import ruixue.rest.repository.ShopsRepository;

@RestController
public class ShopsController {
	@Autowired
	private ShopsRepository repository;
	@RequestMapping("/shops")
	public List<Shop> getShop() {
		return repository.findAll();
	}
}
