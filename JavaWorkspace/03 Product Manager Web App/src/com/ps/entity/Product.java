package com.ps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// ORM related annotations
@Entity
@Table(name = "products")
// Lombok annotations
@NoArgsConstructor
@Setter
@Getter
@ToString // (of = { "productName", "unitPrice" })
public class Product {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator = "increment")
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	@Column(name = "unit_price")
	private Double unitPrice;
	@Column(name = "units_in_stock")
	private Integer unitsInStock;
	@Column(name = "units_on_order")
	private Integer unitsOnOrder;
	@Column(name = "reorder_level")
	private Integer reorderLevel;

	private Boolean discontinued;

	// always EAGER initialization
	@ManyToOne // foreign keys of a table are always represented as many-to-one
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;

	public Product(String productName, String quantityPerUnit, Double unitPrice, Integer unitsInStock) {
		setProductName(productName);
		setUnitPrice(unitPrice);
		setQuantityPerUnit(quantityPerUnit);
		setUnitsInStock(unitsInStock);
	}

}