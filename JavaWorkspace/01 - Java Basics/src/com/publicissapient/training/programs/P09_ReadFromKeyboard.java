package com.publicissapient.training.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P09_ReadFromKeyboard {

	public static void main(String[] args) throws Exception{
		// need to convert System.in to a reader
		InputStreamReader in = new InputStreamReader(System.in);
		// decorator pattern --> add additional methods/features
		BufferedReader reader = new BufferedReader(in); 
		System.out.print("What's your name?: ");
		String name = reader.readLine();
		System.out.println("Hello, " + name);
	}
	
	public static void main_2(String[] args) throws Exception {
		byte[] data = new byte[100];
		System.out.print("What's your name?: ");
		System.in.read(data);
		// System.out.println(Arrays.toString(data));
		String name = new String(data).trim();
		System.out.println("Hello, " + name);
	}
	
	public static void main_1(String[] args) throws Exception {

		System.out.print("What's your name?: ");
		int ch;
		String str = "";
		while ((ch = System.in.read()) != 10) {
			str += (char)ch;
		}

		System.out.println("Hello, " + str);

	}
}
