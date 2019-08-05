package com.publicissapient.training.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String city;
}
