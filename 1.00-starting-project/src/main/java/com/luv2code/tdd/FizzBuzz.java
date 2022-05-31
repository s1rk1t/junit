package com.luv2code.tdd;

public class FizzBuzz {

	public FizzBuzz() {
	}

	public String divByThree(int number) {
		if (number % 3 == 0)
			return "Fizz";
		return Integer.toString(number);
	}

	public String divByFive(int number) {
		if (number % 5 == 0)
			return "Buzz";
		return Integer.toString(number);
	}

	public String divByThreeAndFive(int number) {
		if ((number % 3 == 0) && (number % 5 == 0))
			return "FizzBuzz";
		return Integer.toString(number);
	}

}
