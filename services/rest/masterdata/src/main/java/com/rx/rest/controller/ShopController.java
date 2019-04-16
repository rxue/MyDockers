package com.rx.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rx.entity.Shop;
import com.rx.repository.ShopRepository;

@RestController
public class ShopController {
	@Autowired
	private ShopRepository repository;
	@RequestMapping("/shops")
	public List<Shop> getShops() {
		return repository.findAll();
	}
}
