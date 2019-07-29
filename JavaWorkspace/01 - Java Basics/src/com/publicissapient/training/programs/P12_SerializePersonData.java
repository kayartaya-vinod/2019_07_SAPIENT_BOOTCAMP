package com.publicissapient.training.programs;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.publicissapient.training.entity.Person;

public class P12_SerializePersonData {

	public static void main(String[] args) {
		
		Person[] people = {
			new Person("Ramesh", 33, "Chennai"),
			new Person("Harish", 23, "Delhi"),
			new Person("Rajesh", 55, "Bangalore"),
			new Person("Umesh", 43, "Bangalore"),
			new Person("Naresh", 26, "Chennai")
		};
		
		try(
			FileOutputStream file = new FileOutputStream("people");
			ObjectOutputStream out = new ObjectOutputStream(file);
		) {
			for(Person p: people) {
				out.writeObject(p);
			}
			System.out.println("Done!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
