package com.publicissapient.training.utils;

import java.util.Scanner;

@SuppressWarnings("resource")
public final class KeyboardUtil {
	
	private KeyboardUtil() {
	}
	
	public static int getInt(String message) {
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static String getString(String message) {
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	
}
