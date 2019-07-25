package com.publicissapient.training.programs;

import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class P06_AssertionDemo {

	public static void main(String[] args) {

		int num = (int) sqrt(random() * 1000);
		int rem = num % 50;

		System.out.println("rem = " + rem);

		System.out.println("Before assertion...");
		assert (rem > 25);
		// run with -ea VM arg
		System.out.println("After assertion...");
	}

}
