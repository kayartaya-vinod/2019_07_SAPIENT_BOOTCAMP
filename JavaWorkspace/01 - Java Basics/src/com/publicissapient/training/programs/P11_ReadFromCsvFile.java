package com.publicissapient.training.programs;

import java.io.BufferedReader;
import java.io.FileReader;

public class P11_ReadFromCsvFile {

	public static void main(String[] args) {
		
		try (
			FileReader reader = new FileReader("MOCK_DATA.csv");
			BufferedReader in = new BufferedReader(reader);
		){
			in.readLine(); // skip header
			String data;
			while((data=in.readLine())!=null) {
				String[] ar = data.split(",");
				String name = ar[1];
				String city = ar[3];
				System.out.printf("%s lives in %s\n", name, city);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
