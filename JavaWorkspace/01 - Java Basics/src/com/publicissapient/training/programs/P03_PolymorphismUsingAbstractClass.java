package com.publicissapient.training.programs;

import com.publicissapient.training.entity.Animal;
import com.publicissapient.training.entity.Cat;
import com.publicissapient.training.entity.Dog;
import com.publicissapient.training.entity.Tiger;

public class P03_PolymorphismUsingAbstractClass {
	public static void main(String[] args) {

		Animal a1;

		Cat c1 = new Cat();
		Dog d1 = new Dog();
		Tiger t1 = new Tiger();

		a1 = c1; // up-casting, implicitly done
		a1.talk();
		if(a1 instanceof Cat) {
			((Cat) a1).phurr(); // down-casting; explicitly done
		}
		
		a1 = d1;
		a1.talk();
		if(a1 instanceof Cat) {
			((Cat) a1).phurr(); // down-casting; explicitly done
		}

		a1 = t1;
		a1.talk();

	}
}
