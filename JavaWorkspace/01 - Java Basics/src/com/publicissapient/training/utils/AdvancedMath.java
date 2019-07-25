package com.publicissapient.training.utils;

import java.util.InputMismatchException;

public final class AdvancedMath {

	private AdvancedMath() {
	}

	public static long factorial(int num) {
		if (num < 0) {
			throw new InputMismatchException("factorial for negative number not defined");
		}
		long f = 1;
		while (num > 0) {
			f *= num--;
		}
		return f;
	}
}
