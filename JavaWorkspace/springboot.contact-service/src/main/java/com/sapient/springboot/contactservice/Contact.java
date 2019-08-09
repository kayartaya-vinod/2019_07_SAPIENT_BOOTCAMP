package com.sapient.springboot.contactservice;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement // XML serializable
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@Getter
@Setter
public class Contact {
	@JsonProperty("_id")
	@XmlElement(name = "_id")
	private String id;
	private String firstname;
	private String lastname;
	private String gender = "Male";
	private String email;
	private String phone;
	private Date dob;
	private String address;
	private String city = "Bangalore";
	private String state = "Karnataka";
	private String country = "India";
	private String picture;
}
