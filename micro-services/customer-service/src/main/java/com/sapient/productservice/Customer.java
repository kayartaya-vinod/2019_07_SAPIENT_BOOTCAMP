package com.sapient.productservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Setter
@Getter
public class Customer {
	
	@Id
	@Column(name="customer_id")
	private String customerId;
	@Column(name="company_name")
	private String companyName;
	@Column(name="contact_name")
	private String contactName;
	private String city;
}