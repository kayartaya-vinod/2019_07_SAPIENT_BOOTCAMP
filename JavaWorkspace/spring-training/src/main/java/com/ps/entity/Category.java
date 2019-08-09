package com.ps.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {
	@Id
	@Column(name = "category_id")
	@GeneratedValue(generator = "increment")
	private Integer categoryId;
	@Column(name = "category_name")
	private String categoryName;
	private String description;
	private byte[] picture;

	// always LAZY initialization
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER) // "category" --> member variable in Product.class
	// @JoinColumn(name = "category_id") // "category_id" --> F.Key in PRODUCTS table
	public List<Product> products;
}







