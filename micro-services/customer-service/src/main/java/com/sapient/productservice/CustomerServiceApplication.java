package com.sapient.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/customers")
@RestController
@SpringBootApplication
public class CustomerServiceApplication {
	
	@Autowired
	CustomerRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@GetMapping
	public Iterable<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public Customer getOneCustomer(@PathVariable String id) {
		return repo.findById(id).get();
	}
}
