package com.publicissapient.training.programs;

public class P04_ExceptionsDemo {
	public static void main(String[] args) {
		String input;
		int num, den, quot;
		try {
			input = args[0];
			num = Integer.parseInt(input);
			input = args[1];
			den = Integer.parseInt(input);
			quot = num / den;
			System.out.printf("%d / %d = %d\n", num, den, quot);
		} catch (NumberFormatException e) {
			System.out.println("One of the inputs may not be an integer");
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide an int by zero");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Two integers were expected as command line args");
		} catch (Exception e) {
			System.out.println("There was an error");
		}

		System.out.println("That's all folks!");
	}

}
