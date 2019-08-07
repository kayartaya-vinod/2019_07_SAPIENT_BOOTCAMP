package com.ps.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class ContactDetails {
	private String address;
	private String city;
	private String region;
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	private String country;
}
