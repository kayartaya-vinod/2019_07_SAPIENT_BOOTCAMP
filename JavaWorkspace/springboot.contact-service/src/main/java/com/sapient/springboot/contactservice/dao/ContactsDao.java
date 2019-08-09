package com.sapient.springboot.contactservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.sapient.springboot.contactservice.entity.Contact;

public interface ContactsDao extends CrudRepository<Contact, Integer> {
}
