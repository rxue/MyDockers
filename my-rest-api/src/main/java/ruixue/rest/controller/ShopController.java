package ruixue.rest.controller;

import java.math.BigInteger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ruixue.rest.entity.Shop;

@RestController
@RequestMapping("/shops")
public class ShopController {
	@RequestMapping("/{name}")
	public Shop getShop(@PathVariable("name") String name) {
		Shop shop = new Shop();
		shop.setId(BigInteger.ONE);
		shop.setName(name);
		shop.setArea("Sello");
		return shop;
	}
}
