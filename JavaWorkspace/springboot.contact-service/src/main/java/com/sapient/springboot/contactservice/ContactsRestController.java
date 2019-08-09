package com.sapient.springboot.contactservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/contacts")
@RestController
public class ContactsRestController {

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String info() {
		return "This is a REST endpoint for /api/contacts";
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, 
			produces = {"application/json", "application/xml"})
	public Contact getContactById(@PathVariable String id) {
		// get a contact instance from the DB and return the same
		// temp fix: returning dummy contact
		Contact c = new Contact();
		c.setId(id);
		c.setFirstname("Vinod");
		c.setLastname("Kumar");
		c.setEmail("vinod@vinod.co");
		c.setPhone("9731424784");
		return c;
	}

}










