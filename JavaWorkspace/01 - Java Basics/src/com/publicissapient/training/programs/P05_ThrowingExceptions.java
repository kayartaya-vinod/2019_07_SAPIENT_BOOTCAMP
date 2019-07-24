package com.publicissapient.training.programs;

import com.publicissapient.training.entity.Employee;
import com.publicissapient.training.entity.Gender;
import com.publicissapient.training.entity.InvalidNameException;
import com.publicissapient.training.entity.InvalidSalaryException;

public class P05_ThrowingExceptions {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		try {
			e1.setName("John");
			e1.setSalary(2000.0);
			e1.setGender(Gender.MALE);
			
			System.out.println(e1);
			
		} catch (InvalidNameException e) {
			System.out.println("Invalid name supplied");
		}
		catch(InvalidSalaryException e) {
			System.out.println("Invalid salary");
		}
		
	}
}
