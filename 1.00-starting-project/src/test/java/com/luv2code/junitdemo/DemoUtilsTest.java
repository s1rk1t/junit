package com.luv2code.junitdemo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// @DisplayNameGeneration(DisplayNameGenerator.Simple.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

	DemoUtils demo;

	@BeforeAll
	static void setupBeforeAll() {
		System.out.println("running BeforeAll");
	}

	@AfterAll
	static void tearDownAfterAll() {
		System.out.println("running AfterAll");
	}

	@BeforeEach
	void setupBeforeEach() {
		System.out.println("BeforeEach is running");
		demo = new DemoUtils();
	}

	@AfterEach
	void tearDownAfterEach() {
		System.out.println("running AfterEach");
	}

	@Test
	@DisplayName("Equals and Not Equals")
	@Order(1)
	void testEqualsAndNotEquals() {
		System.out.println("testEqualsAndNotEquals is running");
		assertEquals(6, demo.add(2, 4), "2+4 must equal 6");
		assertNotEquals(7, demo.add(2, 4), "2+4 must not equal 7");
	}

	@Test
	@DisplayName("Null and Not Null")
	@Order(-1)
	void testNullAndNotNull() {
		System.out.println("testNullAndNotNull is running");
		assertNotNull(demo.checkNull(1));

		assertNull(demo.checkNull(null));

	}

	@Test
	@DisplayName("Same and Not Same")
	@Order(2)
	void testSameAndNotSame() {
		String testString = "this is a test";
		String duplicateTestString = testString; // Duplicate Strings should refer to the same object
		String notSame = "this is not the same String";

		assertSame(testString, duplicateTestString);
		assertNotSame(testString, notSame);
	}

	@Test
	@DisplayName("True and False")
	@Order(3)
	void testTrueAndFalse() {
		boolean shouldBeTrue = 1 < 2;
		boolean shouldBeFalse = 1 > 2;

		assertTrue(shouldBeTrue);
		assertFalse(shouldBeFalse);
	}

	@Test
	@DisplayName("Array Equals")
	void testArrayEquals() {
		String[] testArray1 = { "A", "B", "C" };

		String[] testArray2 = { "A", "B", "C" };

		assertArrayEquals(testArray1, testArray2);
	}

	@Test
	@DisplayName("Iterable Equals")
	void testIterableEquals() {
		List<String> testIterable1 = List.of("A", "B", "C");

		List<String> testIterable2 = List.of("A", "B", "C");

		assertIterableEquals(testIterable1, testIterable2);
	}

	@Test
	@DisplayName("Throws and Does not Throw")
	void testThrowsAndDoesNotThrow() {
		assertThrows(Exception.class, () -> {
			demo.throwException(-1);
		});

		assertDoesNotThrow(() -> {
			demo.throwException(10);
		});
	}

	@Test
	@DisplayName("Timeout")
	void testTimeout() {
		assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
			demo.checkTimeout();
		});
	}

}
