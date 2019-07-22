### Assignment 1

1. Write a brief history of Java Programming Language
2. Explain Primitive types in Java
3. What are the different programming constructs in java? Explain with examples.

---

### Assignment 2

Implement the body for the following function:


````java
static boolean isValidDate(int year, int month, int day) { 
	// do stuff here
	return false; 
}
````

The function should check if the parameter values constitute a valid calendar date or not. Accordingly return true or false.


For example,


1) year=2018, month=13, day=1 is an invalid date as the possible values for month is 1 to 12.
2) year=2018, month=2, day=29 is an invalid date as the maximum days in February is 28 in the year 2018
3) year=2016, month=2, day=29 is a valid date.

Write a Java program to call the above function multiple times with different values.


---

### Assignment 3

Implement the body for the following function:

````java
static boolean isPrimeNumber(int num) { 
	// do stuff here
	return false; 
}
````

The function should check and return true only if the number passed as argument is a prime number.
  
Write a Java program to call the above function multiple times with different values.


---

### Assignment 4

Write a function called "sortThreeNumbers", which takes 3 distinct integers and prints them in ascending order.

````java
public void sortThreeNumbers(int a, int b, int c) { 
	// do stuff here
}

````
For example,

* sortThreeNumbers(2, 10, 1); // prints 1, 2, 10 
* sortThreeNumbers(20, 10, 1); // prints 1, 10, 20 
* sortThreeNumbers(2, 10, 100); // prints 2, 10, 100 and so on.


Write a Java program to call the above function multiple times with different values.

---

### Assignment 5

Write a function called "sumOfPrimes", that takes two integers as input and returns the sum of all the prime numbers between the same.

````java
public int sumOfPrimes(int from, int to) { 
	// do stuff here
	return 0; 
}
````

Write a Java program to call the above function multiple times with different values.


---

### Assignment 6

In mathematics, the Fibonacci numbers are the numbers in the following integer sequence, characterized by the fact that every number after the first two numbers is the sum of the two preceding ones:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...

Write a function called "fibonacci", that takes index as paramter and returns the fibonacci number at that index.

````java
public int fibonacci(int index) { 
	// do stuff here
	return 0; 
}
````

---

### Assignment 7

Write a Java program to print the following pattern:

````
*
**
***
****
*****
````

The number of rows should be based on the value of a variable "num", and the number of stars in a row is based on the row number itself.


---

### Assignment 8

In trignometry, the Sine of an angle is represented by the series below:

<img src="images/3d9689077ce39529e3198213901261ebcf48197d.svg">


Write a Java function that accepts angle in degrees and returns the sine of the given angle.

Call the function in main, multiple times by supplying multiple values and verify the same.

PS:
* Divide the function into small reusable functions, if possible.
* Do not use builtin Java classes like `Math`
---
