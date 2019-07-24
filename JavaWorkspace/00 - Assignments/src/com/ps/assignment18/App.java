package com.ps.assignment18;

import java.util.Scanner;

public class App {

	private String getStringFromKeyboard(String message) {
		@SuppressWarnings("resource") // warning is because we are not calling sc.close();
		Scanner sc = new Scanner(System.in); // if you call sc.close(), then you will not be able to read further
		System.out.printf(message);
		return sc.nextLine();
	}

	public void start() {
		int intCount = 0, nonIntCount = 0, sum = 0;
		String intInputs = " ", nonIntInput = " ";

		while (true) {
			String input = getStringFromKeyboard("Enter a number: ");
			try {
				int num = Integer.parseInt(input);
				sum += num;
				intCount++;
				intInputs += num + ", ";
			} catch (Exception e) {
				nonIntCount++;
				nonIntInput += input + ", ";
			}

			input = getStringFromKeyboard("Do you wish to add another? yes/no: ");
			if (input.equalsIgnoreCase("no")) {
				break;
			}
		}

		System.out.printf("Number of inputs = %d\n", intCount + nonIntCount);
		System.out.printf("Number of integer inputs = %d\n", intCount);
		System.out.printf("Number of non-integer inputs = %d\n", nonIntCount);
		System.out.printf("Sum of all integer inputs = %d\n", sum);
		System.out.printf("The integer inputs = %s\n", intInputs);
		System.out.printf("The non-integer inputs = %s\n", nonIntInput);

	}

	public static void main(String[] args) {
		new App().start();
	}

}
