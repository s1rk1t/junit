package com.luv2code.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

	@Test
	@DisplayName("Divisble by Three")
	@Order(1)
	void testForDivisbleByThree() {

		FizzBuzz fb = new FizzBuzz();

		String expected = "Fizz";

		assertEquals(expected, fb.divByThree(3));
	}

	@Test
	@DisplayName("Divisble by Five")
	@Order(2)
	void testForDivisbleByFive() {

		FizzBuzz fb = new FizzBuzz();

		String expected = "Buzz";

		assertEquals(expected, fb.divByFive(5));
	}

	@Test
	@DisplayName("Divisble by Three and Five")
	@Order(3)
	void testForDivisbleByThreeAndFive() {

		FizzBuzz fb = new FizzBuzz();

		String expected = "FizzBuzz";

		assertEquals(expected, fb.divByThreeAndFive(15));
	}

}
