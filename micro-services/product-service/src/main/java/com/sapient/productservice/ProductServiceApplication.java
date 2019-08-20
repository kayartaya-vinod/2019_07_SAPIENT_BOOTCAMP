package com.sapient.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/products")
@RestController
@SpringBootApplication
public class ProductServiceApplication {
	
	@Autowired
	ProductRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@GetMapping
	public Iterable<Product> getAllProducts() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Product getOneProduct(@PathVariable Integer id) {
		return repo.findById(id).get();
	}
}
