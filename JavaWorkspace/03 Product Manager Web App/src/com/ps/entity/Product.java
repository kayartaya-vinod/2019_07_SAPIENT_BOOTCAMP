package com.ps.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// There are no setters and getters
// all are generated using lombok
@NoArgsConstructor
@Setter
@Getter
@ToString(of = { "productName", "unitPrice" })
public class Product {
	// fields
	private Integer productId;
	private String productName;
	private String quantityPerUnit;
	private Double unitPrice;
	private Integer unitsInStock;
	private Integer unitsOnOrder;
	private Integer reorderLevel;
	private Boolean discontinued;

	public Product(String productName, String quantityPerUnit, Double unitPrice, Integer unitsInStock) {
		setProductName(productName);
		setUnitPrice(unitPrice);
		setQuantityPerUnit(quantityPerUnit);
		setUnitsInStock(unitsInStock);
	}

}