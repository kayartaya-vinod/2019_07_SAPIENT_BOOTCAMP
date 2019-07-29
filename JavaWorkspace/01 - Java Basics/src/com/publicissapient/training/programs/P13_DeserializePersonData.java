package com.publicissapient.training.programs;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.publicissapient.training.entity.Person;

public class P13_DeserializePersonData {

	public static void main(String[] args) {

		try (ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("people"));
		) {
			while (true) {
				try {
					Object obj = in.readObject();
					if (obj instanceof Person) {
						Person p = (Person) obj;
						System.out.println(p.getName() + " --> " + p.getCity());
					}
				} catch (EOFException e) {
					break;
				}
			}
			System.out.println("Done!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
