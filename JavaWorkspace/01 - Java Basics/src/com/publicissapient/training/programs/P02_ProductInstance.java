package com.publicissapient.training.programs;

import com.publicissapient.training.entity.Product;

public class P02_ProductInstance {
	
	private int num;
	
	class Hello {
		
		
		
		
	}
	
	class Test {
		final int n;
		
		Test() {
			n = 10;
		}
		
		Test(int n) {
			this.n = n;
		}
		
		public void setN(int n) {
//			this.n = n;
			num = n;
		}
		
		
	}

	public static void main(String[] args) {

		Product p1 = new Product();
		Product p2 = new Product("LG Xyz123", "1 phone per box", 12500.0, 20);
		
		System.out.println(p1);
		System.out.println(p2);
		
	}
}
