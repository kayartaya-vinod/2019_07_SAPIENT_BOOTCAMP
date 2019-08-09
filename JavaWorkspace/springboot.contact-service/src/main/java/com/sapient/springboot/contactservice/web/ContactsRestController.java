package com.sapient.springboot.contactservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.springboot.contactservice.dao.ContactsDao;
import com.sapient.springboot.contactservice.entity.Contact;

@RequestMapping("/api/contacts")
@RestController
@CrossOrigin
public class ContactsRestController {

	@Autowired
	ContactsDao dao;

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String info() {
		return "This is a REST endpoint for /api/contacts";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Contact getContactById(@PathVariable Integer id) {
		return dao.findById(id).get();
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public Iterable<Contact> getAllContacts() {
		return dao.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			produces = "application/json",
			consumes = "application/json")
	public Contact addNewContact(@RequestBody Contact contact) {
		return dao.save(contact);
	}
}




