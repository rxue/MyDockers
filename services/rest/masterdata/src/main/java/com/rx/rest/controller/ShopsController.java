package com.rx.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rx.rest.dao.ShopsRepository;

import com.rx.entity.Shop;

@RestController
public class ShopsController {
	@Autowired
	private ShopsRepository repository;
	@RequestMapping("/shops")
	public List<Shop> getShops() {
		return repository.findAll();
	}
}
