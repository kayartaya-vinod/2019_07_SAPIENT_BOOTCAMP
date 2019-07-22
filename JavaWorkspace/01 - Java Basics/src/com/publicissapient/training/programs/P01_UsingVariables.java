package com.publicissapient.training.programs;

import com.publicissapient.training.entity.Customer;

public class P01_UsingVariables {

	public static void main(String[] args) {
		
		Customer c1; // reference; 8 bytes in stack

		c1 = new Customer();
		
		c1.print();
		
	}
}
