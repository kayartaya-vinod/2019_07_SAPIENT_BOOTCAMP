package com.publicissapient.training.tests;

import java.util.InputMismatchException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.publicissapient.training.utils.AdvancedMath;

public class AdvancedMathTest {
	
	@BeforeClass
	public static void init() {
		System.out.println("init() called");
	}
	
	@AfterClass
	public static void destroy() {
		System.out.println("destroy() called");
	}
	
	@Before
	public void setup() {
		System.out.println("setup() called");
	}
	
	@After
	public void tearDown() {
		System.out.println("tearDown() called\n");
	}

	// positive test case #1 for AdvancedMath.factorial function
	@Test
	public void UTC_01_01() {
		System.out.println("UTC_01_01() called");
		int input = 5;
		long actual = AdvancedMath.factorial(input);
		long expected = 120;

		Assert.assertEquals(expected, actual);
	}

	// positive test case #2 for AdvancedMath.factorial function
	@Test
	public void UTC_01_02() {
		System.out.println("UTC_01_02() called");
		int input = 4;
		long actual = AdvancedMath.factorial(input);
		long expected = 24;

		Assert.assertEquals(expected, actual);
	}

	// positive test case #3 for AdvancedMath.factorial function
	@Test
	public void UTC_01_03() {
		System.out.println("UTC_01_03() called");
		int input = 0;
		long actual = AdvancedMath.factorial(input);
		long expected = 1;

		Assert.assertEquals(expected, actual);
	}

	// negative test case #4 for AdvancedMath.factorial function
	@Test(expected = InputMismatchException.class)
	public void UTC_01_04() {
		System.out.println("UTC_01_04() called");
		int input = -4;
		AdvancedMath.factorial(input);
	}

}
